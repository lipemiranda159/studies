using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Transparencia.Brasil.SDK.Entities;
using Transparencia.Brasil.SDK.InfraStructure;

namespace Transparencia.Brasil.SDK.Resources
{
    public class Estados
    {
        public IList<Estado> Todos()
        {
            return APIClientFactory<IList<Estado>>.Get("/estados");
        }
    }
}
