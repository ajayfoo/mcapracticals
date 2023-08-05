using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practical8.e
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Application["Name"] != null || Application["Branch"] != null
            ||
            Application["Age"] != null)
            {
                Label1.Text = "Name: " + Application["Name"].ToString();
                Label2.Text = "Age: " + Application["Age"].ToString();
                Label3.Text = "Branch: " + Application["Branch"].ToString();
            }
        }
    }
}