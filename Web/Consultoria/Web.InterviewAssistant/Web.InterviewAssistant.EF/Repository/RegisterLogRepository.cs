﻿using Data.UnitOfWork;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Web.InterviewAssistant.Entities;
using Web.InterviewAssistant.Entities.Repository;
using System.Data.Entity;

namespace Web.InterviewAssistant.EF.Repository
{
    public class RegisterLogRepository : EntityRepositoryAsync<RegisterLog>, IRegisterLogRepository
    {
        public RegisterLogRepository(DbContext context) : base(context)
        {
        }
    }
}
