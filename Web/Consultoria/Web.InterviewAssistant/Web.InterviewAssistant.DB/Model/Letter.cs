using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Web.InterviewAssistant.DB.Model
{
    public class Letter
    {
        public int letterId { get; set; }
        public Interview interview { get; set; }
    }
}
