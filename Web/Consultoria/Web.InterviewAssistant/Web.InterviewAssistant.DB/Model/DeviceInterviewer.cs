using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Web.InterviewAssistant.DB.Model
{
    public class DeviceInterviewer
    {
        public int deviceInterviewerId { get; set; }
        public Interviewer interviewer { get; set; }
        public Device device { get; set; }
        public short status { get; set; }
    }
}
