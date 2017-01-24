using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Consultoria.Test
{
    class Program
    {
        private static string _texto = getText();
        static void Main(string[] args)
        {
            foreach (var printer in System.Drawing.Printing.PrinterSettings.InstalledPrinters)
            {
                Console.WriteLine(printer.ToString());
                Console.ReadLine();
            }

            using (var printDocument = new System.Drawing.Printing.PrintDocument())
            {
                printDocument.PrintPage += printDocument_PrintPage;
                printDocument.PrinterSettings.PrinterName = "Microsoft print to PDF";
                printDocument.Print();
            }
            Console.ReadLine();
        }

        static string getText() {
            return "1\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "2\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "3\n,Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "4\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "5\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n";/* +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n" +
                        "Teste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\nTeste de impressão\n";
                        */
        }



        static void printDocument_PrintPage(object sender,System.Drawing.Printing.PrintPageEventArgs e)
        {
            
            var printDocument = sender as System.Drawing.Printing.PrintDocument;
            if (printDocument != null)
            {
                using (var fonte = new Font("Times New Roman", 14))
                using (var brush = new SolidBrush(Color.Black))
                {
                    int caracteresNaPagina = 0;
                    int linhasPorPagina = 0;

                    e.Graphics.MeasureString(
                        _texto, fonte, e.MarginBounds.Size, StringFormat.GenericTypographic,
                        out caracteresNaPagina, out linhasPorPagina);

                    e.Graphics.DrawString(
                        _texto.Substring(0, caracteresNaPagina),
                        fonte,
                        brush,
                        e.MarginBounds);

                    _texto = _texto.Substring(caracteresNaPagina);
                    
                    e.HasMorePages = _texto.Length > 0;
                }
            }
        }
    }
}
