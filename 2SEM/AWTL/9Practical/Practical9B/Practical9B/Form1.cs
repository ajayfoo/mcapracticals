using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Practical9B
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private void button1_Click(object sender, EventArgs e)
        {
            Service1 obj = new
            Service1();
            resultLbl.Text = obj.Addition(Convert.ToInt32(textBox1.Text),
            Convert.ToInt32(textBox2.Text)).ToString();
        }
        private void button2_Click(object sender, EventArgs e)
        {
            Service1 obj = new
            Service1();
            resultLbl.Text = obj.Subtraction(Convert.ToInt32(textBox1.Text),
            Convert.ToInt32(textBox2.Text)).ToString();
        }
        private void button3_Click(object sender, EventArgs e)
        {
            Service1 obj = new Service1();
            resultLbl.Text =
            obj.Multiplication(Convert.ToInt32(textBox1.Text),
            Convert.ToInt32(textBox2.Text)).ToString();
        }
        private void button4_Click(object sender, EventArgs e)
        {
            Service1 obj = new
            Service1();
            resultLbl.Text = obj.Division(Convert.ToInt32(textBox1.Text),
            Convert.ToInt32(textBox2.Text)).ToString();
        }
    }
}
