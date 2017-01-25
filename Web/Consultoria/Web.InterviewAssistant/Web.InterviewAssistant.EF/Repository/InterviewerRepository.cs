using Data.UnitOfWork;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Web.InterviewAssistant.Entities;
using System.Data.Entity;

namespace Web.InterviewAssistant.EF.Repository
{
    public class InterviewerRepository : EntityRepositoryAsync<Interviewer>, IInterviewerRepository
    {
        public InterviewerRepository(DbContext context) : base(context)
        {
        }
    }
}
