using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Web.InterviewAssistant.Entities
{
    public class RegisterLog
    {
        public int registerLogId { get; set; }
        public short type { get; set; }
        public string Message { get; set; }
    }
}
