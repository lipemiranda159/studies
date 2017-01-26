namespace Web.InterviewAssistant.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class createdatabase : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.TbDeviceInterviewers",
                c => new
                    {
                        deviceInterviewerId = c.Int(nullable: false, identity: true),
                        status = c.Short(nullable: false),
                        device_deviceId = c.Int(),
                        interviewer_interviewerId = c.Int(),
                    })
                .PrimaryKey(t => t.deviceInterviewerId)
                .ForeignKey("dbo.TbDevices", t => t.device_deviceId)
                .ForeignKey("dbo.TbInterviewers", t => t.interviewer_interviewerId)
                .Index(t => t.device_deviceId)
                .Index(t => t.interviewer_interviewerId);
            
            CreateTable(
                "dbo.TbDevices",
                c => new
                    {
                        deviceId = c.Int(nullable: false, identity: true),
                        lastUpdate = c.DateTime(nullable: false),
                        lastLogitude = c.Int(nullable: false),
                        lastLatitude = c.Int(nullable: false),
                        active = c.Boolean(nullable: false),
                    })
                .PrimaryKey(t => t.deviceId);
            
            CreateTable(
                "dbo.TbInterviewers",
                c => new
                    {
                        interviewerId = c.Int(nullable: false, identity: true),
                        name = c.String(),
                    })
                .PrimaryKey(t => t.interviewerId);
            
            CreateTable(
                "dbo.TbIntervieweds",
                c => new
                    {
                        interviewedId = c.Int(nullable: false, identity: true),
                        name = c.String(),
                        addres = c.String(),
                        tel = c.String(),
                    })
                .PrimaryKey(t => t.interviewedId);
            
            CreateTable(
                "dbo.TbLetters",
                c => new
                    {
                        letterId = c.Int(nullable: false, identity: true),
                        interview_interviewId = c.Int(),
                    })
                .PrimaryKey(t => t.letterId)
                .ForeignKey("dbo.TbInterviews", t => t.interview_interviewId)
                .Index(t => t.interview_interviewId);
            
            CreateTable(
                "dbo.TbInterviews",
                c => new
                    {
                        interviewId = c.Int(nullable: false, identity: true),
                        verifyAge = c.Boolean(nullable: false),
                        dateStart = c.String(),
                        dateFinish = c.String(),
                        viewerFound = c.Boolean(nullable: false),
                        viewerAccept = c.Boolean(nullable: false),
                        useSus = c.Boolean(nullable: false),
                        idProcedure = c.Short(nullable: false),
                        procedureHospital = c.Boolean(nullable: false),
                        IDHospital = c.Short(nullable: false),
                        otherHospital = c.String(),
                        useMedicalPlan = c.Boolean(nullable: false),
                        IDProblemWithPlan = c.Short(nullable: false),
                        IDSickness = c.Short(nullable: false),
                        needGetBetter = c.Short(nullable: false),
                        qualityOfSus = c.Short(nullable: false),
                        otherImprovement = c.String(),
                        IDOcupation = c.Short(nullable: false),
                        otherOcupation = c.String(),
                        degreeSchool = c.Short(nullable: false),
                        liveWith = c.Short(nullable: false),
                        otherDweller = c.String(),
                        hasChildren = c.Boolean(nullable: false),
                        religion = c.Short(nullable: false),
                        aboutElection = c.Short(nullable: false),
                        willVote = c.Boolean(nullable: false),
                        howSelectCandidate = c.Short(nullable: false),
                        whatTheyDo = c.Boolean(nullable: false),
                        describePoliticJob = c.Short(nullable: false),
                        knowSuperSimples = c.Boolean(nullable: false),
                        funcAposentado = c.Boolean(nullable: false),
                        aposentada = c.Boolean(nullable: false),
                        motivoDesemprego = c.Short(nullable: false),
                        desemSelec = c.Short(nullable: false),
                        respDesempenho = c.Short(nullable: false),
                    })
                .PrimaryKey(t => t.interviewId);
            
            CreateTable(
                "dbo.TbUsers",
                c => new
                    {
                        userId = c.Int(nullable: false, identity: true),
                        name = c.String(),
                        login = c.String(),
                        password = c.String(),
                    })
                .PrimaryKey(t => t.userId);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.TbLetters", "interview_interviewId", "dbo.TbInterviews");
            DropForeignKey("dbo.TbDeviceInterviewers", "interviewer_interviewerId", "dbo.TbInterviewers");
            DropForeignKey("dbo.TbDeviceInterviewers", "device_deviceId", "dbo.TbDevices");
            DropIndex("dbo.TbLetters", new[] { "interview_interviewId" });
            DropIndex("dbo.TbDeviceInterviewers", new[] { "interviewer_interviewerId" });
            DropIndex("dbo.TbDeviceInterviewers", new[] { "device_deviceId" });
            DropTable("dbo.TbUsers");
            DropTable("dbo.TbInterviews");
            DropTable("dbo.TbLetters");
            DropTable("dbo.TbIntervieweds");
            DropTable("dbo.TbInterviewers");
            DropTable("dbo.TbDevices");
            DropTable("dbo.TbDeviceInterviewers");
        }
    }
}
