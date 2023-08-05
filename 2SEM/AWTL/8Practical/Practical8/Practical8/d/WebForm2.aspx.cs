using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practical8.d
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["Name"] != null || Session["Branch"] != null ||
            Session["Age"] != null)
            {
                Label1.Text = "Name: " + Session["Name"].ToString();
                Label2.Text = "Age: " + Session["Age"].ToString();
                Label3.Text = "Branch: " + Session["Branch"].ToString();
            }
        }
    }
}