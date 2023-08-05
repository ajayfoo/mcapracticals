using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practical8
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            String value1 = Request.Form["HiddenField1"];
            String value2 = Request.Form["HiddenField2"];
            String value3 = Request.Form["HiddenField3"];
            Label1.Text = value1;
            Label2.Text = value2;
            Label3.Text = value3;
        }
    }
}