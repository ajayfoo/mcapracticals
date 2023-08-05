using _2Practical.utility;
namespace _2Practical
{
    public partial class MoneyConverterForm : Form
    {
        public MoneyConverterForm()
        {
            InitializeComponent();
            inputCurrCbb.DataSource = Enum.GetNames(typeof(Currency));
            outputCurrCbb.DataSource = Enum.GetNames(typeof(Currency));
            outputCurrCbb.SelectedIndex = (int)Currency.INR;
        }
        private void updateOutputAmt()
        {
            Currency sourceCurr = (Currency)this.inputCurrCbb.SelectedIndex;
            Currency destCurr = (Currency)this.outputCurrCbb.SelectedIndex;
            try
            {
                double srcAmt = Convert.ToDouble(this.inputAmtTxt.Text);
                outputAmtTxt.Text = MoneyConverter.convert(sourceCurr, destCurr, srcAmt).ToString("0.##");
            }
            catch (System.FormatException)
            {
                outputAmtTxt.Text = "";
            }
        }
        private void updateInputAmt()
        {
            Currency sourceCurr = (Currency)this.outputCurrCbb.SelectedIndex;
            Currency destCurr = (Currency)this.inputCurrCbb.SelectedIndex;
            try
            {
                double srcAmt = Convert.ToDouble(this.outputAmtTxt.Text);
                inputAmtTxt.Text = MoneyConverter.convert(sourceCurr, destCurr, srcAmt).ToString("0.##");
            }
            catch (System.FormatException)
            {
                inputAmtTxt.Text = "";
            }
        }

        private void inputCurr_SelectedIndexChanged(object sender, EventArgs e)
        {
            updateOutputAmt();
        }
        private void inputAmt_TextChanged(object sender, EventArgs e)
        {
            if (ActiveControl == outputAmtTxt) return;
            updateOutputAmt();
        }
        private void outputAmt_TextChanged(object sender, EventArgs e)
        {
            if (ActiveControl == inputAmtTxt) return;
            updateInputAmt();
        }
        private void outputCurr_SelectedIndexChanged(object sender, EventArgs e)
        {
            updateInputAmt();
        }
    }
}
