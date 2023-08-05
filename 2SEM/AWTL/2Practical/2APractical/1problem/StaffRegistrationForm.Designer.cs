namespace _2APractical._1problem
{
    partial class StaffRegistrationForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            addStaffBtn = new Button();
            label2 = new Label();
            label3 = new Label();
            postCbb = new ComboBox();
            nameTxt = new TextBox();
            noOfStaffs = new Label();
            showHodsBtn = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 15);
            label1.Name = "label1";
            label1.Size = new Size(39, 15);
            label1.TabIndex = 0;
            label1.Text = "Name";
            // 
            // addStaffBtn
            // 
            addStaffBtn.Location = new Point(17, 121);
            addStaffBtn.Name = "addStaffBtn";
            addStaffBtn.Size = new Size(75, 23);
            addStaffBtn.TabIndex = 1;
            addStaffBtn.Text = "Add";
            addStaffBtn.UseVisualStyleBackColor = true;
            addStaffBtn.Click += addStaffBtn_Click;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(12, 52);
            label2.Name = "label2";
            label2.Size = new Size(30, 15);
            label2.TabIndex = 2;
            label2.Text = "Post";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(12, 83);
            label3.Name = "label3";
            label3.Size = new Size(80, 15);
            label3.TabIndex = 3;
            label3.Text = "No. of Staff(s)";
            // 
            // postCbb
            // 
            postCbb.FormattingEnabled = true;
            postCbb.Location = new Point(117, 49);
            postCbb.Name = "postCbb";
            postCbb.Size = new Size(121, 23);
            postCbb.TabIndex = 4;
            // 
            // nameTxt
            // 
            nameTxt.Location = new Point(117, 12);
            nameTxt.Name = "nameTxt";
            nameTxt.Size = new Size(100, 23);
            nameTxt.TabIndex = 5;
            // 
            // noOfStaffs
            // 
            noOfStaffs.AutoSize = true;
            noOfStaffs.Location = new Point(117, 83);
            noOfStaffs.Name = "noOfStaffs";
            noOfStaffs.Size = new Size(13, 15);
            noOfStaffs.TabIndex = 6;
            noOfStaffs.Text = "0";
            // 
            // showHodsBtn
            // 
            showHodsBtn.Location = new Point(117, 122);
            showHodsBtn.Name = "showHodsBtn";
            showHodsBtn.Size = new Size(88, 23);
            showHodsBtn.TabIndex = 7;
            showHodsBtn.Text = "Show HODS";
            showHodsBtn.UseVisualStyleBackColor = true;
            showHodsBtn.Click += showHodsBtn_Click;
            // 
            // StaffRegistrationForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(246, 156);
            Controls.Add(showHodsBtn);
            Controls.Add(noOfStaffs);
            Controls.Add(nameTxt);
            Controls.Add(postCbb);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(addStaffBtn);
            Controls.Add(label1);
            Name = "StaffRegistrationForm";
            Text = "Staff Registration Form";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Button addStaffBtn;
        private Label label2;
        private Label label3;
        private ComboBox postCbb;
        private TextBox nameTxt;
        private Label noOfStaffs;
        private Button showHodsBtn;
    }
}