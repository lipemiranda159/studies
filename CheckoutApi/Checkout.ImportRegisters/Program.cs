using CheckoutApi.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace Checkout.ImportRegisters
{
    class Program
    {
        static List<string> GetSheets()
        {
            var listSheets = new List<string>();
            listSheets.Add("Setembro14");
            listSheets.Add("Outubro14");
            listSheets.Add("Novembro14");
            listSheets.Add("Dezembro14");
            listSheets.Add("Janeiro15");
            listSheets.Add("Fevereiro15");
            listSheets.Add("Março15");
            listSheets.Add("Abril15");
            listSheets.Add("Maio15");
            listSheets.Add("Junho15");
            listSheets.Add("Julho15");
            listSheets.Add("Agosto");
            listSheets.Add("Setembro");
            listSheets.Add("Outubro");
            listSheets.Add("Novembro");
            listSheets.Add("Dezembro");
            listSheets.Add("Janeiro");
            listSheets.Add("Fevereiro");
            listSheets.Add("Março");
            listSheets.Add("Abril");
            listSheets.Add("Maio");
            listSheets.Add("Junho");
            listSheets.Add("Julho");

            return listSheets;

        }

        static void AddRegister(DateTime date, string type)
        {
            CheckoutApiContext db = new CheckoutApiContext();
            var register = new Register()
            {
                Day = date.Day,
                Month = date.Month,
                Year = date.Year,
                Hour = date.Hour,
                Minutes = date.Minute,
                Time = date,
                Description = string.Format("{0} - dia: {1}", type, date.ToString("yyyy-MM-dd"))
            };

            db.Registers.Add(register);
            db.SaveChanges();
        }

        static void Main(string[] args)
        {

            var fileName = string.Format("{0}{1}", AppDomain.CurrentDomain.BaseDirectory, "ponto.xls");
            OleDbConnection conexao = new OleDbConnection(string.Format("Provider =Microsoft.Jet.OLEDB.4.0; Data Source = {0}; Extended Properties=Excel 8.0", fileName));
            conexao.Open();

            foreach (var item in GetSheets())
            {

                Console.WriteLine(string.Format("Iniciando importação mês: {0}", item));
                OleDbDataAdapter adapter = new OleDbDataAdapter(string.Format("Select * from [{0}$]", item), conexao);
                DataSet ds = new DataSet();

                
                adapter.Fill(ds);

                foreach (DataRow linha in ds.Tables[0].Rows)
                {
                    if (!string.IsNullOrEmpty(linha["Data Atual:"].ToString()))
                    {
                        var entrada = DateTime.Parse(string.Format("{0} {1}", DateTime.Parse(linha["Data Atual:"].ToString()).ToString("yyyy-MM-dd"), DateTime.Parse(linha["ENTRADA"].ToString()).ToString("hh:mm:ss").ToString()));
                        var saida = DateTime.Parse(string.Format("{0} {1}", DateTime.Parse(linha["Data Atual:"].ToString()).ToString("yyyy-MM-dd"), DateTime.Parse(linha["SAÍDA"].ToString()).ToString("hh:mm:ss").ToString()));
                        Console.WriteLine("Entrada: {0} – Saída: {1}", entrada, saida);
                        AddRegister(entrada, "Entrada");
                        AddRegister(saida, "Saída");
                    }
                    else
                    {
                        Console.WriteLine("Fim - mês: {0}",item);
                        Console.ReadLine();
                        break;
                    }

                }

            }
            Console.ReadLine();


        }
    }
}
