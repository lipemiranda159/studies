using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace BookStore.Models
{
    public class BookStoreContextInitializer : DropCreateDatabaseAlways<BookStoreContext>
    {
        protected override void Seed(BookStoreContext context)
        {
            var books = new List<Book>
            {
                new Book() { Name = "teste", Author = "teste", Price = 19.95m }
            };

            books.ForEach(b => context.Books.Add(b));
            context.SaveChanges();

            var order = new Order() { Customer = "teste", OrderDate = DateTime.Now };

            var details = new List<OrderDetail>()
            {
                    new OrderDetail() { book = books[0], Quantity = 1, Order = order}
            };

            context.Orders.Add(order);
            details.ForEach(o => context.OrderDetails.Add(o));


            order = new Order() { Customer = "teste2", OrderDate = DateTime.Now };

            details = new List<OrderDetail>()
            {
                    new OrderDetail() { book = books[0], Quantity = 2, Order = order}
            };

            context.Orders.Add(order);
            details.ForEach(o => context.OrderDetails.Add(o));
            context.SaveChanges();

            base.Seed(context);
        }
    }
}