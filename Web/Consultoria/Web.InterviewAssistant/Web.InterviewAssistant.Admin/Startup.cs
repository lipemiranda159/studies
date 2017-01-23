using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Web.InterviewAssistant.Admin.Startup))]
namespace Web.InterviewAssistant.Admin
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
