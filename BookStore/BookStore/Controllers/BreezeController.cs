﻿using BookStore.Models;
using Breeze.ContextProvider;
using Breeze.WebApi2;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace BookStore.Controllers
{
    [BreezeController]
    public class BreezeController : ApiController
    {
        private readonly IRepository _repository;

        public BreezeController(IRepository repository)
        {
            _repository = repository;
        }

        public string Metadata()
        {
            return _repository.Metadata;
        }

        public SaveResult SaveChanges(JObject saveBundle)
        {
            return _repository.SaveChanges(saveBundle);
        }

        public IQueryable<Book> Books()
        {
            return _repository.Books();

        }

        public IQueryable<Order> Orders()
        {
            return _repository.Orders();
        }
    }
}