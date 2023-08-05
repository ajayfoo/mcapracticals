using System;
using System.Collections;
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
    public partial class StaffRegistrationForm : Form
    {
        private uint _noOfStaffs = 0;
        private List<Staff> staffs = new();
        public StaffRegistrationForm()
        {
            InitializeComponent();
            postCbb.DataSource = Enum.GetValues(typeof(Post));
        }
        private void IncrementNoOfStaffs()
        {
            ++_noOfStaffs;
            noOfStaffs.Text = _noOfStaffs.ToString();
        }
        private void AddStaff()
        {
            Post post = (Post)postCbb.SelectedIndex;
            Staff staff = new Staff(nameTxt.Text, post);
            staffs.Add(staff);
            IncrementNoOfStaffs();
        }
        private void addStaffBtn_Click(object sender, EventArgs e)
        {
            AddStaff();
            nameTxt.Text = "";
        }
        private void ShowHODS(List<Staff> hods)
        {
            List<string> hodsNames = new();
            foreach (Staff staff in hods)
            {
                hodsNames.Add(staff.Name);
            }
            HODListForm hODListForm = new(hodsNames);
            hODListForm.Show();
        }
        private void showHodsBtn_Click(object sender, EventArgs e)
        {
            List<Staff> hods = staffs.FindAll(staff => staff.Post == Post.HOD);
            if (hods.Count == 0)
            {
                MessageBox.Show("No HODS are there.");
            }
            else
            {
                ShowHODS(hods);
            }
        }
    }
}
