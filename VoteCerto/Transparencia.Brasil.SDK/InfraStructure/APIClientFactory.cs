using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Transparencia.Brasil.SDK.InfraStructure
{
    public class APIClientFactory<T>
    {
        public static T Get(string templateUri,string host, string appToken)
        {
            return new APIClient<T>(host, appToken).Get(templateUri);
        }
    }
}
