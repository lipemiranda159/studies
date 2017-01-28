using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;
using System.Web.Http.Description;
using Web.InterviewAssistant.EF;
using Web.InterviewAssistant.Entities;

namespace Web.InterviewAssistant.Api.Controllers
{
    public class RegisterLogsController : ApiController
    {
        private InterviewDbContext db = new InterviewDbContext();

        // GET: api/RegisterLogs
        public IQueryable<RegisterLog> GetRegisterLogs()
        {
            return db.RegisterLogs;
        }

        // GET: api/RegisterLogs/5
        [ResponseType(typeof(RegisterLog))]
        public async Task<IHttpActionResult> GetRegisterLog(int id)
        {
            RegisterLog registerLog = await db.RegisterLogs.FindAsync(id);
            if (registerLog == null)
            {
                return NotFound();
            }

            return Ok(registerLog);
        }

        // PUT: api/RegisterLogs/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutRegisterLog(int id, RegisterLog registerLog)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != registerLog.registerLogId)
            {
                return BadRequest();
            }

            db.Entry(registerLog).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!RegisterLogExists(id))
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

        // POST: api/RegisterLogs
        [ResponseType(typeof(RegisterLog))]
        public async Task<IHttpActionResult> PostRegisterLog(RegisterLog registerLog)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.RegisterLogs.Add(registerLog);
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = registerLog.registerLogId }, registerLog);
        }

        // DELETE: api/RegisterLogs/5
        [ResponseType(typeof(RegisterLog))]
        public async Task<IHttpActionResult> DeleteRegisterLog(int id)
        {
            RegisterLog registerLog = await db.RegisterLogs.FindAsync(id);
            if (registerLog == null)
            {
                return NotFound();
            }

            db.RegisterLogs.Remove(registerLog);
            await db.SaveChangesAsync();

            return Ok(registerLog);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool RegisterLogExists(int id)
        {
            return db.RegisterLogs.Count(e => e.registerLogId == id) > 0;
        }
    }
}