using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using Transparencia.Brasil.SDK.Entities;
using Transparencia.Brasil.SDK.Resources;

namespace VoteCerto
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                var candidatos = new Candidatos();

                var listCandidatos = candidatos.Todos("mg","1");

                foreach (var item in listCandidatos)
                {
                    Console.WriteLine(string.Format("id: {0} - name: {1} - miniBio: {2}", item.id, item.nome, item.miniBio));
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            Console.ReadLine();
        }
    }
}
