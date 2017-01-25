using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.UnitOfWork
{
    public class UnitOfWorkDbContext : DbContext, IUnitOfWork
    {
        public UnitOfWorkDbContext()
        {
        }
        public UnitOfWorkDbContext(string nameOrConnectionString)
        {

        }
        public void Save()
        {
            
        }
    }
}
