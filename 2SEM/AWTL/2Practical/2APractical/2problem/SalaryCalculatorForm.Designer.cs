namespace _2APractical._2problem
{
    partial class SalaryCalculatorForm
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
            label2 = new Label();
            label3 = new Label();
            findSalBtn = new Button();
            basicTxt = new TextBox();
            taTxt = new TextBox();
            daTxt = new TextBox();
            hraTxt = new TextBox();
            label4 = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 15);
            label1.Name = "label1";
            label1.Size = new Size(34, 15);
            label1.TabIndex = 0;
            label1.Text = "Basic";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(12, 47);
            label2.Name = "label2";
            label2.Size = new Size(20, 15);
            label2.TabIndex = 1;
            label2.Text = "TA";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(12, 76);
            label3.Name = "label3";
            label3.Size = new Size(23, 15);
            label3.TabIndex = 2;
            label3.Text = "DA";
            // 
            // findSalBtn
            // 
            findSalBtn.Location = new Point(35, 153);
            findSalBtn.Name = "findSalBtn";
            findSalBtn.Size = new Size(101, 23);
            findSalBtn.TabIndex = 3;
            findSalBtn.Text = "Find My Salary";
            findSalBtn.UseVisualStyleBackColor = true;
            findSalBtn.Click += findSalBtn_Click;
            // 
            // basicTxt
            // 
            basicTxt.Location = new Point(83, 12);
            basicTxt.Name = "basicTxt";
            basicTxt.Size = new Size(100, 23);
            basicTxt.TabIndex = 4;
            // 
            // taTxt
            // 
            taTxt.Location = new Point(83, 44);
            taTxt.Name = "taTxt";
            taTxt.Size = new Size(100, 23);
            taTxt.TabIndex = 5;
            // 
            // daTxt
            // 
            daTxt.Location = new Point(83, 76);
            daTxt.Name = "daTxt";
            daTxt.Size = new Size(100, 23);
            daTxt.TabIndex = 6;
            // 
            // hraTxt
            // 
            hraTxt.Location = new Point(83, 108);
            hraTxt.Name = "hraTxt";
            hraTxt.Size = new Size(100, 23);
            hraTxt.TabIndex = 7;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(12, 111);
            label4.Name = "label4";
            label4.Size = new Size(31, 15);
            label4.TabIndex = 8;
            label4.Text = "HRA";
            // 
            // SalaryCalculator
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(199, 192);
            Controls.Add(label4);
            Controls.Add(hraTxt);
            Controls.Add(daTxt);
            Controls.Add(taTxt);
            Controls.Add(basicTxt);
            Controls.Add(findSalBtn);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "SalaryCalculator";
            Text = "SalaryCalculator";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Button findSalBtn;
        private TextBox basicTxt;
        private TextBox taTxt;
        private TextBox daTxt;
        private TextBox hraTxt;
        private Label label4;
    }
}