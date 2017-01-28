using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Web.InterviewAssistant.Entities;

namespace Web.InterviewAssistant.EF.Mapping
{
    internal partial class InterviewMapping : EntityTypeConfiguration<Interview>
    {
        public InterviewMapping()
        {
            this.ToTable("dbo.TbInterviews");
        }
    }
}
