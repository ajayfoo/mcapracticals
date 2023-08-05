using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practical8.e
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Button1_Click(object sender, EventArgs e)
        {
            Application["Name"] = TextBox1.Text;
            Application["Age"] = TextBox2.Text;
            Application["Branch"] = TextBox3.Text;
            Response.Redirect("WebForm2.aspx");
        }
    }
}