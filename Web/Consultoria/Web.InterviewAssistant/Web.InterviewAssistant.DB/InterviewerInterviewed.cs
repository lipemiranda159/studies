using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Web.InterviewAssistant.Entities
{
    public class InterviewerInterviewed
    {
        public int intervieweInterviewedId { get; set; }
        public Interview interview { get; set; }
        public Interviewed interviewed { get; set; }
        public Interviewer interviewer { get; set; }
        public DateTime Date { get; set; }
        public short status { get; set; }
    }
}
