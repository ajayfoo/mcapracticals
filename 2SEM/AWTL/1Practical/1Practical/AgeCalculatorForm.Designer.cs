namespace _2Practical
{
    partial class AgeCalculatorForm
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
            findAgeBtn = new Button();
            dobTxt = new TextBox();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 15);
            label1.Name = "label1";
            label1.Size = new Size(109, 15);
            label1.TabIndex = 0;
            label1.Text = "DOB(dd/mm/yyyy)";
            // 
            // findAgeBtn
            // 
            findAgeBtn.Location = new Point(82, 56);
            findAgeBtn.Name = "findAgeBtn";
            findAgeBtn.Size = new Size(117, 23);
            findAgeBtn.TabIndex = 1;
            findAgeBtn.Text = "Find My Age";
            findAgeBtn.UseVisualStyleBackColor = true;
            findAgeBtn.Click += findAgeBtn_Click;
            // 
            // dobTxt
            // 
            dobTxt.Location = new Point(183, 12);
            dobTxt.Name = "dobTxt";
            dobTxt.Size = new Size(100, 23);
            dobTxt.TabIndex = 2;
            // 
            // AgeCalculatorForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(290, 91);
            Controls.Add(dobTxt);
            Controls.Add(findAgeBtn);
            Controls.Add(label1);
            Name = "AgeCalculatorForm";
            Text = "AgeCalculator";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Button findAgeBtn;
        private TextBox dobTxt;
    }
}