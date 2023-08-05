using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Data.SqlClient;
using System.Data;

namespace Practical9
{
    /// <summary>
    /// Summary description for WebService1
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WebService1 : System.Web.Services.WebService
    {
        private SqlConnection sqlcon = new SqlConnection("Data Source=SNAKEJAZZ\\SQLEXPRESS;Initial Catalog=coll;Integrated Security=True");
        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }
        public DataTable Get()
        {
            using (SqlCommand cmd = new SqlCommand("SELECT * FROM ajayk57_games"))
            {
                using (SqlDataAdapter sda = new SqlDataAdapter())
                {
                    cmd.Connection = sqlcon;
                    sda.SelectCommand = cmd;
                    DataTable dt = new DataTable();
                    dt.TableName = "Games";
                    sda.Fill(dt);
                    return dt;
                }
            }
        }

        [WebMethod]
        public void AddData(String name, int id, bool is_outdoor, int pcount)
        {
            SqlCommand cmd = new SqlCommand("INSERT INTO ajayk57_games(id, name, is_outdoor, pcount) VALUES( @id,@Name, @is_outdoor, @pcount)");
            cmd.Parameters.AddWithValue("@name", name);
            cmd.Parameters.AddWithValue("@id", id);
            cmd.Parameters.AddWithValue("@is_outdoor", is_outdoor);
            cmd.Parameters.AddWithValue("@pcount", pcount);
            cmd.Connection = sqlcon;
            sqlcon.Open();
            cmd.ExecuteNonQuery();
            sqlcon.Close();
        }
    }
}
