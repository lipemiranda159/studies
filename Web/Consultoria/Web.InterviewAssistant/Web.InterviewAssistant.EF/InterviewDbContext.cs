﻿using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Data.UnitOfWork;
using Web.InterviewAssistant.EF.Repository;
using Web.InterviewAssistant.Entities;

namespace Web.InterviewAssistant.EF
{
    public class InterviewDbContext : DbContext, IBaseContext
    {
        public InterviewDbContext()
            : base("name=ConnectionString")
        {
            DeviceInterviewerRepository = new DeviceInterviewerRepository(this);
            DeviceRepository = new DeviceRepository(this);
            InterviewedRepository = new InterviewedRepository(this);
            InterviewerRepository = new InterviewerRepository(this);
            LetterRepository = new LetterRepository(this);
            UserRepository = new UserRepository(this);
        }

        public DbSet<DeviceInterviewer> DeviceInterviewers { get; set; }
        public DbSet<Device> Devices { get; set; }
        public DbSet<Interviewed> Intervieweds { get; set; }
        public DbSet<Interviewer> Interviwers { get; set; }
        public DbSet<Letter> Letters { get; set; }
        public DbSet<User> Users { get; set; }

        public IDeviceInterviewerRepository DeviceInterviewerRepository { get; set; }

        public IDeviceRepository DeviceRepository { get; set; }

        public IInterviewedRepository InterviewedRepository { get; set; }

        public IInterviewerRepository InterviewerRepository { get; set; }

        public ILetterRepository LetterRepository { get; set; }

        public IUserRepository UserRepository { get; set; }


        public Task SaveChanges()
        {
            return SaveChangesAsync();
        }
    }
}
