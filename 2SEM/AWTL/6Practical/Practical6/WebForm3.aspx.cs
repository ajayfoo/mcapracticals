using System;
using System.Data;
using System.Data.SqlClient;

namespace Practical6
{
    public partial class WebForm3 : System.Web.UI.Page
    {
        static StudentService StudentService;
        protected void Page_Load(object sender, EventArgs e)
        {
            StudentService = new StudentService();
        }

        protected void TextBox1_TextChanged(object sender, EventArgs e)
        {
        }

        protected void RegBtn_Click(object sender, EventArgs e)
        {
            //SqlConnection conn = new SqlConnection("Data Source=DESKTOP-OUL5TLP\\SQLEXPRESS;Initial Catalog=coll;Integrated Security=True");
            //SqlCommand cmd = new SqlCommand("ajayk57_sql2", conn);
            //cmd.CommandType = CommandType.StoredProcedure;
            //SqlParameter sqlpId = new SqlParameter("@id", SqlDbType.Int);
            //SqlParameter sqlpName = new SqlParameter("@Name", SqlDbType.VarChar);
            //SqlParameter sqlpScore = new SqlParameter("@score", SqlDbType.Int);
            //sqlpId.Value = TextBox1.Text;
            //sqlpName.Value = TextBox2.Text;
            //sqlpScore.Value = TextBox3.Text;
            //cmd.Parameters.Add(sqlpId);
            //cmd.Parameters.Add(sqlpName);
            //cmd.Parameters.Add(sqlpScore);
            //conn.Open();


            //cmd.ExecuteNonQuery();
            //Label1.Text = "Succeeded";


            //Console.WriteLine("huh?");
            //Label1.Text = "Failed";

            if (StudentService.AddStudentEntry(TextBox1.Text, TextBox2.Text, TextBox3.Text))
            {
                Label1.Text = "Succeeded";
            }
            else
            {
                Label1.Text = "Failed";
            }
        }
    }
}