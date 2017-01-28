namespace Web.InterviewAssistant.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class createlogdatefield : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.TbRegisterLog", "LogDate", c => c.DateTime(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.TbRegisterLog", "LogDate");
        }
    }
}
