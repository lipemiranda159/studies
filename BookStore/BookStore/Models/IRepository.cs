using Breeze.ContextProvider;
using Newtonsoft.Json.Linq;
using System.Linq;

namespace BookStore.Models
{
    public interface IRepository
    {
        string Metadata { get; }

        SaveResult SaveChanges(JObject saveBundle);

        IQueryable<Book> Books();
        IQueryable<Order> Orders();
    }
}