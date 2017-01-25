using Data.UnitOfWork;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Web.InterviewAssistant.Entities;

namespace Web.InterviewAssistant.EF.Repository
{
    public interface IDeviceRepository : IEntityRepositoryAsync<Device>
    {
    }
}
