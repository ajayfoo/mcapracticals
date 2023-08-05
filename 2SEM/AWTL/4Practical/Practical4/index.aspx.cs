using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practical4
{
    public partial class index : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void submitBtn_Click(object sender, EventArgs e)
        {
            if (IsValid)
            {
                Response.Redirect("success-page.aspx?name="+nameLbl.Text+"&email="+emailLbl.Text);
            }
        }
    }
}