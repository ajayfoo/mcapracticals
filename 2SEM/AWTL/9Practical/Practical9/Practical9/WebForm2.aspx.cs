using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practical9
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            WebService1 obj1 = new WebService1();
            GridView1.DataSource = obj1.Get();
            GridView1.DataBind(); 
        }
        protected void Button1_Click(object sender, EventArgs e)
        {
            int id = Int32.Parse(idTxt.Text);
            String name = nameTxt.Text;
            bool is_outdoor = outdoorChkBx.Checked;
            int pcount = Convert.ToInt32(pcountTxt.Text);
            WebService1 obj1 = new WebService1();
            obj1.AddData(name, id, is_outdoor, pcount);
            statusLbl.Text = "Success";
            GridView1.DataSource = obj1.Get();
            GridView1.DataBind();
        } 
    }
}