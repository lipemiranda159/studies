using BookStore.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace BookStore.Controllers
{
    public class OrderController : ApiController
    {
        private IRepository _repository;

        public OrderController(IRepository repository)
        {
            _repository = repository;
        }

        public IQueryable<Order> Get()
        {
            return _repository.GetAllOrders();
        }

        public IQueryable<Order> Get(bool includeDetails)
        {
            IQueryable<Order> query;

            if (includeDetails)
            {
                query = _repository.GetAllOrdersWithDetails();
            }
            else query = _repository.GetAllOrders();

            return query;
        }

        public Order Get(int id)
        {
            return _repository.GetOrder(id);
        }
    }
}
