using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Web.InterviewAssistant.EF.Repository;

namespace Web.InterviewAssistant.EF
{
    public interface IBaseContext : IDisposable
    {
        IDeviceInterviewRepository DeviceInterviewRepository { get; set; }
        IDeviceRepository DeviceRepository { get; set; }
        IInterviewedRepository InterviewedRepository { get; set; }
        IInterviewerRepository InterviewerRepository { get; set; }
        ILetterRepository LetterRepository { get; set; }
        IUserRepository UserRepository { get; set; }

    }
}
