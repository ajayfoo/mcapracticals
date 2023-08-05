using System;
using System.Data;
using System.Data.SqlClient;

namespace Practical6
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            using (SqlConnection con = new SqlConnection("Data Source=DESKTOP-OUL5TLP\\SQLEXPRESS;Initial Catalog=coll;Integrated Security=True"))
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ajayk57_sql", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlDataReader rdr = cmd.ExecuteReader();
                GridView1.DataSource = rdr;
                GridView1.DataBind();
            }

        }

    }
}