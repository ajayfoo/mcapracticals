using System;
using System.Data;
using System.Data.SqlClient;

namespace Practical6
{
    public class StudentService
    {
        readonly SqlCommand cmd = new SqlCommand();
        readonly SqlParameter sqlpId = new SqlParameter("@id", SqlDbType.Int);
        readonly SqlParameter sqlpName = new SqlParameter("@Name", SqlDbType.VarChar);
        readonly SqlParameter sqlpScore = new SqlParameter("@score", SqlDbType.Int);
        internal StudentService()
        {
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.Add(sqlpId);
            cmd.Parameters.Add(sqlpName);
            cmd.Parameters.Add(sqlpScore);
            cmd.CommandText = "ajayk57_sql2";
        }
        internal bool AddStudentEntry(string id, string name, string score)
        {
            using (SqlConnection conn = new SqlConnection("Data Source=DESKTOP-OUL5TLP\\SQLEXPRESS;Initial Catalog=coll;Integrated Security=True"))
            {
                cmd.Connection = conn;
                sqlpId.Value = id;
                sqlpName.Value = name;
                sqlpScore.Value = score;
                conn.Open();
                try
                {
                    cmd.ExecuteNonQuery();
                    return true;
                }
                catch (Exception exc)
                {
                    Console.WriteLine(exc.Message);
                    return false;
                }
            }

        }
    }
}