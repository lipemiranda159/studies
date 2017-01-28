namespace Web.InterviewAssistant.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class update : DbMigration
    {
        public override void Up()
        {
            //RenameTable("dbo.Interviews","TbInterviews");
        }
        
        public override void Down()
        {
            //RenameTable("dbo.TbInterviews","Interviews");
        }
    }
}
