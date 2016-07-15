using System;
using System.Threading;
using System.Threading.Tasks;
using Lime.Protocol;
using Takenet.MessagingHub.Client;
using Takenet.MessagingHub.Client.Listener;
using Takenet.MessagingHub.Client.Sender;
using Transparencia.Brasil.SDK.Resources;

namespace VoteCerto.ClassLibary
{
    public class PlainTextMessageReceiver : IMessageReceiver
    {
        private readonly IMessagingHubSender _sender;

        public PlainTextMessageReceiver(IMessagingHubSender sender)
        {
            _sender = sender;
        }

        public async Task ReceiveAsync(Message message, CancellationToken cancellationToken)
        {
            //Console.WriteLine($"From: {message.From} \tContent: {message.Content}");
            //await _sender.SendMessageAsync("Pong!", message.From, cancellationToken);
            var command = message.Content.ToString();
            if (command.Contains("start"))
            {
                await _sender.SendMessageAsync("Seja bem vindo! Este bot foi feito para te ajudar a pegar informações sobre candidatos de eleição.", message.From, cancellationToken);
            }
            else if (command.Contains("candidato"))
            {
                await _sender.SendMessageAsync("Envie sg: sigla, cargo: valor para pesquisar os valores", message.From, cancellationToken);
            }
            else if (command.Contains("sg"))
            {
                var candidato = new Candidatos();
                var list = candidato.Todos("mg", "1");

                foreach (var item in list)
                {
                    await _sender.SendMessageAsync($"Nome:{item.nome} - MiniBio: {item.miniBio}", message.From, cancellationToken);
                }
            }

        }
    }
}
