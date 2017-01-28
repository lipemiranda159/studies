using Data.UnitOfWork;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Web.InterviewAssistant.EF;
using Web.InterviewAssistant.EF.Repository;
using Web.InterviewAssistant.Entities.Repository;

namespace Web.InterviewAssistant.EF
{
    public interface IBaseContext : IUnitOfWork
    {
        IDeviceInterviewerRepository DeviceInterviewerRepository { get; set; }
        IDeviceRepository DeviceRepository { get; set; }
        IInterviewedRepository InterviewedRepository { get; set; }
        IInterviewerRepository InterviewerRepository { get; set; }
        ILetterRepository LetterRepository { get; set; }
        IUserRepository UserRepository { get; set; }
        IRegisterLogRepository RegisterLogRepository { get; set; } 
    }
}
