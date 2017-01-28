using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Web.InterviewAssistant.Entities;

namespace Web.InterviewAssistant.EF.Mapping
{
    public class RegisterLogMapping : EntityTypeConfiguration<RegisterLog>
    {
        public RegisterLogMapping()
        {
            this.ToTable("dbo.TbLogRegister");
        }
    }
}
