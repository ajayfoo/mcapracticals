using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practical7
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void FindIDBtn_Click(object sender, EventArgs e)
        {
            try
            {
                int id = Convert.ToInt32(IDTxt.Text);

                DataClasses1DataContext dbCon = new
DataClasses1DataContext();
                GridView1.DataSource = (from book in dbCon.ajayk57_libraries
                                        where
                                            book.id == id
                                        select book);
                GridView1.DataBind();
            }
            catch (Exception)
            {
                Response.Write("Please enter a valid, integer");
            }
        }
        protected void AllRecBtn_Click(object sender, EventArgs e)
        {
            DataClasses1DataContext dbCon = new DataClasses1DataContext();
            GridView1.DataSource = (from book in dbCon.ajayk57_libraries select book);
            GridView1.DataBind();
        }
    }
}