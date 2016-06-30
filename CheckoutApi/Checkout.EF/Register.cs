using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace CheckoutApi.Models
{
    public class Register
    {
        public int Id { get; set; }
        public int Day { get; set; }
        public int Month { get; set; }
        public int Year { get; set; }
        public int Hour { get; set; }
        public int Minutes { get; set; }
        [DataType(DataType.DateTime)]
        public DateTime Time { get; set; }
        public string Description { get; set; }
    }
}