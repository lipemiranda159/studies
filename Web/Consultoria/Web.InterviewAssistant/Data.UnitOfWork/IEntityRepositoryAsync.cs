using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.UnitOfWork
{
    public interface IEntityRepositoryAsync<T> where T : class
    {
        Task<IQueryable<T>> GetAllAsync();
        Task<T> GetByIdAsync(int? id);
        Task AddAsync(T entity);
        Task DeleteAsync(T entity);
        Task DeleteAsync(int id);
        Task UpdateAsync(T entity);
    }

}
