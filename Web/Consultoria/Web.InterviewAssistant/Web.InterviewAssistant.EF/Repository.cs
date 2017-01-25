using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace Web.InterviewAssistant.EF
{
    public class Repository<T> : IUnitOfWork<T> where T : class
    {
        public void Delete(T model)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<T> GetAll()
        {
            throw new NotImplementedException();
        }

        public T GetById(object id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<T> OrderBy(Expression<Func<T, bool>> expression)
        {
            throw new NotImplementedException();
        }

        public int Save(T model)
        {
            throw new NotImplementedException();
        }

        public int Update(T model)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<T> Where(Expression<Func<T, bool>> expression)
        {
            throw new NotImplementedException();
        }
    }
}
