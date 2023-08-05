using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practical8
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Button2_Click(object sender, EventArgs e)
        {
            HiddenField1.Value = TextBox1.Text;
            HiddenField2.Value = TextBox2.Text;
            HiddenField3.Value = TextBox3.Text;
            Response.Write(HiddenField1.Value);
            Response.Write(HiddenField2.Value);
            Response.Write(HiddenField3.Value);
        }
    }
}