using System;
using System.Threading;
using System.Threading.Tasks;
using Lime.Protocol;
using Takenet.MessagingHub.Client;
using Takenet.MessagingHub.Client.Listener;
using Takenet.MessagingHub.Client.Sender;
using Transparencia.Brasil.SDK.Resources;
using Lime.Messaging.Contents;
using System.Collections.Generic;

namespace VoteCerto.ClassLibary
{
    public class PlainTextMessageReceiver : IMessageReceiver
    {
        private readonly IMessagingHubSender _sender;
        private readonly IDictionary<string, object> _settings;

        public PlainTextMessageReceiver(IMessagingHubSender sender, IDictionary<string, object> settings)
        {
            _sender = sender;
            _settings = settings;

        }

        public async Task ReceiveAsync(Message message, CancellationToken cancellationToken)
        {
            //Console.WriteLine($"From: {message.From} \tContent: {message.Content}");
            //await _sender.SendMessageAsync("Pong!", message.From, cancellationToken);
            var command = message.Content.ToString().ToLower();
            if (command.Contains("start"))
            {
                await _sender.SendMessageAsync("Seja bem vindo! Este bot foi feito para te ajudar a pegar informações sobre candidatos de eleição.", message.From, cancellationToken);
            }
            else if (command.Contains("candidato"))
            {
                await _sender.SendMessageAsync("Envie o estado e o cargo desejado separado por virgula. Ex.: estado MG,1", message.From, cancellationToken);
            }
            else if (command.Contains("estado"))
            {
                var candidato = new Candidatos(_settings["host"].ToString(), _settings["appToken"].ToString());
                command = command.Replace("estado", string.Empty).Trim();
                var opt = command.Split(',');
                var listCandidatos = candidato.Todos(opt[0], opt[1]);

                foreach (var item in listCandidatos)
                {
                    await _sender.SendMessageAsync($"Nome: {item.nome} MiniBio: {item.miniBio}", message.From, cancellationToken);

                }

            }
            else
            {
                await _sender.SendMessageAsync("Comando inválido.", message.From, cancellationToken);

            }

        }
    }
}
