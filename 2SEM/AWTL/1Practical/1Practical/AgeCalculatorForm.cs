using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _2Practical
{
    public partial class AgeCalculatorForm : Form
    {
        public AgeCalculatorForm()
        {
            InitializeComponent();
        }
        private void showResultMessageBox()
        {
            try
            {
                DateTime dob = DateTime.Parse(dobTxt.Text);
                TimeSpan age = DateTime.Now - dob;
                MessageBox.Show($"You are {Math.Round((age.TotalDays/365))} year(s) old.","Age Found", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            catch
            {
                MessageBox.Show("Please Enter the date in the right format", "Wrong Date Format", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void findAgeBtn_Click(object sender, EventArgs e)
        {
            showResultMessageBox();
        }
    }
}
