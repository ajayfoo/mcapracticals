using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practical8
{
    public partial class WebForm3 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Button2_Click(object sender, EventArgs e)
        {
            HttpCookie cookie = new HttpCookie("userinformation");
            cookie["Name"] = TextBox1.Text;
            cookie["Age"] = TextBox2.Text;
            cookie["Branch"] = TextBox3.Text;
            Response.Cookies.Add(cookie);
            Response.Redirect("WebForm4.aspx");
        } 
    }
}