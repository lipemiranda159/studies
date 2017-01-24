using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace Web.InterviewAssistant.EF
{
    public class BaseContext<T> : DbContext where T : class
    {
        public DbSet<T> DbSet
        {
            get;
            set;
        }

        public BaseContext()
            : base("InterviewAssistant")
        {
            //Caso a base de dados não tenha sido criada, ao iniciar a aplicação iremos criar
            Database.SetInitializer<BaseContext<T>>(null);
        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            
        }


        public virtual void ChangeObjectState(object model, EntityState state)
        {
        }

        public virtual int Save(T model)
        {
            this.DbSet.Add(model);
            return this.SaveChanges();
        }

        public virtual int Update(T model)
        {
            var entry = this.Entry(model);

            if (entry.State == EntityState.Detached)
                this.DbSet.Attach(model);

            this.ChangeObjectState(model, EntityState.Modified);
            return this.SaveChanges();
        }

        public virtual void Delete(T model)
        {
            var entry = this.Entry(model);

            if (entry.State == EntityState.Detached)
                this.DbSet.Attach(model);

            this.ChangeObjectState(model, EntityState.Deleted);
            this.SaveChanges();
        }

        public virtual IEnumerable<T> GetAll()
        {
            return this.DbSet.ToList();
        }

        public virtual T GetById(object id)
        {
            return this.DbSet.Find(id);
        }

        public virtual IEnumerable<T> Where(Expression<Func<T, bool>> expression)
        {
            return this.DbSet.Where(expression);
        }

        public IEnumerable<T> OrderBy(Expression<Func<T, bool>> expression)
        {
            return this.DbSet.OrderBy(expression);
        }
    }
}
