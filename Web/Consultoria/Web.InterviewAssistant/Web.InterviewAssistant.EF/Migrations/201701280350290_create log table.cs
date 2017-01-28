namespace Web.InterviewAssistant.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class createlogtable : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.RegisterLogs",
                c => new
                    {
                        registerLogId = c.Int(nullable: false, identity: true),
                        type = c.Short(nullable: false),
                        Message = c.String(),
                    })
                .PrimaryKey(t => t.registerLogId);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.RegisterLogs");
        }
    }
}
