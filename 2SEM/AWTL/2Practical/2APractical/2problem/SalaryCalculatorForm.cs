using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _2APractical._2problem
{
    public partial class SalaryCalculatorForm : Form
    {
        public SalaryCalculatorForm()
        {
            InitializeComponent();
        }
        private void ShowSalary()
        {
            Salary salary;
            if(daTxt.Text=="" || hraTxt.Text == "")
            {
                salary = new(Convert.ToDecimal(basicTxt.Text), Convert.ToByte(taTxt.Text));
            }
            else
            {
                salary = new(Convert.ToDecimal(basicTxt.Text), Convert.ToByte(taTxt.Text),
                     Convert.ToByte(daTxt.Text), Convert.ToByte(hraTxt.Text));
            }
            MessageBox.Show($"Your salary is {salary.get().ToString("0.##")}");
        }
        private void findSalBtn_Click(object sender, EventArgs e)
        {
            ShowSalary();
        }
    }
}
