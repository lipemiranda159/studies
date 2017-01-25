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
    public class DeviceRepository : EntityRepositoryAsync<Device>
    {
        public DeviceRepository(DbContext context) : base(context)
        {
        }
    }
}
