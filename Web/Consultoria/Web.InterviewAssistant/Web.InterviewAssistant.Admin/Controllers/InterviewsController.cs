using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Web.InterviewAssistant.EF;
using Web.InterviewAssistant.Entities;

namespace Web.InterviewAssistant.Admin.Controllers
{
    public class InterviewsController : Controller
    {
        private InterviewDbContext db = new InterviewDbContext();

        // GET: Interviews
        public async Task<ActionResult> Index()
        {
            return View(await db.Interviews.ToListAsync());
        }

        // GET: Interviews/Details/5
        public async Task<ActionResult> Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Interview interview = await db.Interviews.FindAsync(id);
            if (interview == null)
            {
                return HttpNotFound();
            }
            return View(interview);
        }

        // GET: Interviews/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Interviews/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create([Bind(Include = "interviewId,verifyAge,dateStart,dateFinish,viewerFound,viewerAccept,useSus,idProcedure,procedureHospital,IDHospital,otherHospital,useMedicalPlan,IDProblemWithPlan,IDSickness,needGetBetter,qualityOfSus,otherImprovement,IDOcupation,otherOcupation,degreeSchool,liveWith,otherDweller,hasChildren,religion,aboutElection,willVote,howSelectCandidate,whatTheyDo,describePoliticJob,knowSuperSimples,funcAposentado,aposentada,motivoDesemprego,desemSelec,respDesempenho")] Interview interview)
        {
            if (ModelState.IsValid)
            {
                db.Interviews.Add(interview);
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }

            return View(interview);
        }

        // GET: Interviews/Edit/5
        public async Task<ActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Interview interview = await db.Interviews.FindAsync(id);
            if (interview == null)
            {
                return HttpNotFound();
            }
            return View(interview);
        }

        // POST: Interviews/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit([Bind(Include = "interviewId,verifyAge,dateStart,dateFinish,viewerFound,viewerAccept,useSus,idProcedure,procedureHospital,IDHospital,otherHospital,useMedicalPlan,IDProblemWithPlan,IDSickness,needGetBetter,qualityOfSus,otherImprovement,IDOcupation,otherOcupation,degreeSchool,liveWith,otherDweller,hasChildren,religion,aboutElection,willVote,howSelectCandidate,whatTheyDo,describePoliticJob,knowSuperSimples,funcAposentado,aposentada,motivoDesemprego,desemSelec,respDesempenho")] Interview interview)
        {
            if (ModelState.IsValid)
            {
                db.Entry(interview).State = EntityState.Modified;
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            return View(interview);
        }

        // GET: Interviews/Delete/5
        public async Task<ActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Interview interview = await db.Interviews.FindAsync(id);
            if (interview == null)
            {
                return HttpNotFound();
            }
            return View(interview);
        }

        // POST: Interviews/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteConfirmed(int id)
        {
            Interview interview = await db.Interviews.FindAsync(id);
            db.Interviews.Remove(interview);
            await db.SaveChangesAsync();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
