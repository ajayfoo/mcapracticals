using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practical8
{
    public partial class WebForm4 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            HttpCookie cookie1 = Request.Cookies["userinformation"];
            Label1.Text = cookie1["Name"];
            Label2.Text = cookie1["Age"];
            Label3.Text = cookie1["Branch"];
        }
    }
}