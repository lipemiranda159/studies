using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BookStore.Models
{
    public class Repository
    {
        private BookStoreContext db;

        public Repository(BookStoreContext db)
        {
            this.db = db;
        }
    }
}