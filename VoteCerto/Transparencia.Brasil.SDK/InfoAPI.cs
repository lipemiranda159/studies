using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Transparencia.Brasil.SDK
{
    public class InfoAPI
    {
        //<add key = "host" value="http://api.transparencia.org.br/" />
        //<add key = "enviroment" value="api/" />
        //<add key = "version" value="v1" />
        //<add key = "appToken" value="gyMdMNFsBdBQ " />

        private string _host;
        private string _appToken;

        public string Host
        {
            get
            {
                return _host;
            }

            set
            {
                _host = value;
            }
        }

        public string AppToken
        {
            get
            {
                return _appToken;
            }

            set
            {
                _appToken = value;
            }
        }

        public InfoAPI(string host, string appToken)
        {
            Host = host;
            AppToken = appToken;
        }
    }
}
