using System;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using Web.InterviewAssistant.EF;

namespace Data.UnitOfWork
{
    public class EntityRepositoryAsync<T> : IEntityRepositoryAsync<T> where T : class
    {
        protected internal readonly DbContext _context;

        public EntityRepositoryAsync(DbContext context)
        {
            _context = context;
        }

        public async Task AddAsync(T entity)
        {
            await _context.Set<T>.AddAsync(entity);
        }

        public Task DeleteAsync(int id)
        {
            throw new NotImplementedException();
        }

        public Task DeleteAsync(T entity)
        {
            throw new NotImplementedException();
        }

        public Task<IQueryable<T>> GetAllAsync()
        {
            throw new NotImplementedException();
        }

        public Task<T> GetByIdAsync(int? id)
        {
            throw new NotImplementedException();
        }

        public Task UpdateAsync(T entity)
        {
            throw new NotImplementedException();
        }
    }
}
