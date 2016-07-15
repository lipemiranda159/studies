using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Transparencia.Brasil.SDK.Entities;
using Transparencia.Brasil.SDK.InfraStructure;

namespace Transparencia.Brasil.SDK.Resources
{
    public class Partidos : InfoAPI
    {
        public Partidos(string host, string appToken) : base(host, appToken)
        {
        }

        public IList<Partido> Todos()
        {
            return APIClientFactory<IList<Partido>>.Get("/partidos", Host, AppToken);
        }
    }
}
