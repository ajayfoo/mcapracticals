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
    public partial class TemperatureConverterForm : Form
    {
        public TemperatureConverterForm()
        {
            InitializeComponent();
        }
        private static string FahrenheitToCelsius(double f)
        {
            double c = ((f - 32) * 5) / 9;
            return c.ToString("0.##");
        }
        private static string CelsiusToFahrenheit(double c)
        {
            double f = ((c * 9) / 5) + 32;
            return f.ToString("0.##");
        }
        private void updateFhrnTxt()
        {
            try
            {
                double c = Convert.ToDouble(celsTxt.Text);
                fhrnTxt.Text = CelsiusToFahrenheit(c);
            }
            catch (FormatException)
            {
                fhrnTxt.Text = "";
            }
        }
        private void updateCelsTxt()
        {
            try
            {
                double f = Convert.ToDouble(fhrnTxt.Text);
                celsTxt.Text = FahrenheitToCelsius(f);
            }
            catch (FormatException)
            {
                celsTxt.Text = "";
            }
        }
        private void fhrnTxt_TextChanged(object sender, EventArgs e)
        {
            if (ActiveControl == celsTxt) return;
            updateCelsTxt();
        }

        private void celsTxt_TextChanged(object sender, EventArgs e)
        {
            if (ActiveControl == fhrnTxt) return;
            updateFhrnTxt();
        }
    }
}
