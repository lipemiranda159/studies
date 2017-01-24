using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Web.InterviewAssistant.DB.Model
{
    public class User
    {
        public int userId { get; set; }
        public string name { get; set; }
        public string login { get; set; }
        public string password { get; set; }
    }
}
