using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Web.InterviewAssistant.EF.Repository;

namespace Web.InterviewAssistant.EF
{
    public class InterviewDbContext : DbContext, IBaseContext
    {
        public InterviewDbContext()
            : base("name=ConnectionString")
        {
            DeviceInterviewRepository = new DeviceInterviewerRepository(this);
        }
        public IDeviceInterviewerRepository DeviceInterviewRepository { get; set; }

        public IDeviceRepository DeviceRepository { get; set; }

        public IInterviewedRepository InterviewedRepository { get; set; }

        public IInterviewerRepository InterviewerRepository { get; set; }

        public ILetterRepository LetterRepository { get; set; }

        public IUserRepository UserRepository { get; set; }

        public void Save()
        {

        }
    }
}
