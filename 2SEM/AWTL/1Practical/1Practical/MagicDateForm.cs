namespace _2Practical
{
    public partial class MagicDateForm : Form
    {
        public MagicDateForm()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void checkBtn_Click(object sender, EventArgs e)
        {
            int day = Convert.ToInt32(dayTb.Text);
            int month = Convert.ToInt32(monthTb.Text);
            int year = Convert.ToInt32(yearTb.Text);
            string result = "The entered date is ";
            if (year != (day * month))
            {
                result += "not ";
            }
            result += "a magic date";
            MessageBox.Show(result, "caption", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
    }
}