using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Web.InterviewAssistant.DB.Model
{
    public class Device
    {
        public int deviceId { get; set; }
        public DateTime lastUpdate { get; set; }
        public int lastLogitude { get; set; }
        public int lastLatitude { get; set; }
        public bool active { get; set; }
    }
}
