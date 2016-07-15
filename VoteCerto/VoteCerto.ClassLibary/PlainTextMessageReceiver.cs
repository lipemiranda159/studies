using System;
using System.Threading;
using System.Threading.Tasks;
using Lime.Protocol;
using Takenet.MessagingHub.Client;
using Takenet.MessagingHub.Client.Listener;
using Takenet.MessagingHub.Client.Sender;
using Transparencia.Brasil.SDK.Resources;
using Lime.Messaging.Contents;

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
                var document = new Select
                {
                    Text = "Escolha uma opção:",
                    Options = new[]
                    {
                        new SelectOption
                        {
                            Order = 1,
                            Text = "Pegar todos",
                            Value = new PlainText { Text = "1" }
                        },
                        new SelectOption
                        {
                            Order = 2,
                            Text = "Uma imagem motivacional!",
                            Value = new PlainText { Text = "2" }
                        },
                        new SelectOption
                        {
                            Order = 3,
                            Text = "Um link para algo interessante!",
                            Value = new PlainText { Text = "3" }
                        }
                    }
                };
                await _sender.SendMessageAsync(document, message.From, cancellationToken);
            }
        }
    }
}
