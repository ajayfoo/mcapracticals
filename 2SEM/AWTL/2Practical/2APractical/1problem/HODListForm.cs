using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _2APractical._1problem
{
    public partial class HODListForm : Form
    {
        internal HODListForm(List<string> hods)
        {
            InitializeComponent();
            hodsLbx.DataSource = hods;
        }
    }
}
