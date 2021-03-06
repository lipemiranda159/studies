﻿using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using Web.InterviewAssistant.EF;
using Web.InterviewAssistant.Entities;

namespace Web.InterviewAssistant.Api.Controllers
{
    public class InterviewsController : ApiController
    {
        private InterviewDbContext db = new InterviewDbContext();

        private RegisterLog createLog(string message)
        {
            var result = new RegisterLog();
            result.Message = message;
            result.type = 0;
            result.LogDate = DateTime.Now;

            return result;
        }

        // GET: api/Interviews
        public IQueryable<Interview> GetInterviews()
        {
            return db.Interviews;
        }

        // GET: api/Interviews/5
        [ResponseType(typeof(Interview))]
        public IHttpActionResult GetInterview(int id)
        {
            Interview interview = db.Interviews.Find(id);
            if (interview == null)
            {
                return NotFound();
            }

            return Ok(interview);
        }

        // PUT: api/Interviews/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutInterview(int id, Interview interview)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != interview.interviewId)
            {
                return BadRequest();
            }

            db.Entry(interview).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!InterviewExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Interviews
        [ResponseType(typeof(Interview))]
        public IHttpActionResult PostInterview(Interview interview)
        {
            db.RegisterLogs.Add(createLog("Recebi requisição - "+DateTime.Now.ToString()));
            if (!ModelState.IsValid)
            {
                db.RegisterLogs.Add(createLog("Modelo inválido"));
                return BadRequest(ModelState);
            }            

            db.RegisterLogs.Add(createLog("Modelo válido - json: "+ JsonConvert.SerializeObject(interview)));

            db.Interviews.Add(interview);
            db.RegisterLogs.Add(createLog("entrevista salva"));
            db.SaveChanges().Wait();
            return CreatedAtRoute("DefaultApi", new { id = interview.interviewId }, interview);
        }

        // DELETE: api/Interviews/5
        [ResponseType(typeof(Interview))]
        public IHttpActionResult DeleteInterview(int id)
        {
            Interview interview = db.Interviews.Find(id);
            if (interview == null)
            {
                return NotFound();
            }

            db.Interviews.Remove(interview);
            db.SaveChanges();

            return Ok(interview);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool InterviewExists(int id)
        {
            return db.Interviews.Count(e => e.interviewId == id) > 0;
        }
    }
}