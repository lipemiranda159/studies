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
    public class DeviceInterviewRepository : EntityRepositoryAsync<DeviceInterviewer>
    {
        public DeviceInterviewRepository(DbContext context) : base(context)
        {
        }
    }
}
