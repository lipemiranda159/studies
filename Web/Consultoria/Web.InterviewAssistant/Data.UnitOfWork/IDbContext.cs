using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Web.InterviewAssistant.EF;
using Web.InterviewAssistant.EF.Repository;
using Web.InterviewAssistant.Entities;

namespace Data.UnitOfWork
{
    public interface IDbContext
    {
        IDbSet<Device> Devices { get; set; }
        IDbSet<DeviceInterviewer> DeviceInterviewers { get; set; }
        IDbSet<Interview> Interviews { get; set; }
        IDbSet<Interviewed> Intervieweds { get; set; }
        IDbSet<IntervieweInterviewed> IntervieweIntervieweds { get; set; }
        IDbSet<Interviewer> Interviewers { get; set; }
        IDbSet<Letter> Letters { get; set; }
        IDbSet<User> Users { get; set; }
    }
}
