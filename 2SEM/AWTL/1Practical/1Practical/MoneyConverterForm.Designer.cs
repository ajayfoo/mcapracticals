namespace _2Practical
{
    partial class MoneyConverterForm
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
            inputCurrCbb = new ComboBox();
            groupBox1 = new GroupBox();
            inputAmtTxt = new TextBox();
            groupBox2 = new GroupBox();
            outputAmtTxt = new TextBox();
            outputCurrCbb = new ComboBox();
            groupBox1.SuspendLayout();
            groupBox2.SuspendLayout();
            SuspendLayout();
            // 
            // inputCurrCbb
            // 
            inputCurrCbb.FormattingEnabled = true;
            inputCurrCbb.Location = new Point(6, 22);
            inputCurrCbb.Name = "inputCurrCbb";
            inputCurrCbb.Size = new Size(121, 23);
            inputCurrCbb.TabIndex = 0;
            inputCurrCbb.SelectedIndexChanged += inputCurr_SelectedIndexChanged;
            // 
            // groupBox1
            // 
            groupBox1.Controls.Add(inputCurrCbb);
            groupBox1.Controls.Add(inputAmtTxt);
            groupBox1.Font = new Font("Segoe UI", 9F, FontStyle.Regular, GraphicsUnit.Point);
            groupBox1.Location = new Point(12, 12);
            groupBox1.Name = "groupBox1";
            groupBox1.Size = new Size(259, 58);
            groupBox1.TabIndex = 2;
            groupBox1.TabStop = false;
            groupBox1.Text = "Input";
            // 
            // inputAmtTxt
            // 
            inputAmtTxt.Location = new Point(144, 22);
            inputAmtTxt.Name = "inputAmtTxt";
            inputAmtTxt.Size = new Size(100, 23);
            inputAmtTxt.TabIndex = 1;
            inputAmtTxt.TextChanged += inputAmt_TextChanged;
            // 
            // groupBox2
            // 
            groupBox2.Controls.Add(outputAmtTxt);
            groupBox2.Controls.Add(outputCurrCbb);
            groupBox2.Font = new Font("Segoe UI", 9F, FontStyle.Regular, GraphicsUnit.Point);
            groupBox2.Location = new Point(12, 76);
            groupBox2.Name = "groupBox2";
            groupBox2.Size = new Size(259, 58);
            groupBox2.TabIndex = 3;
            groupBox2.TabStop = false;
            groupBox2.Text = "Output";
            // 
            // outputAmtTxt
            // 
            outputAmtTxt.Location = new Point(144, 22);
            outputAmtTxt.Name = "outputAmtTxt";
            outputAmtTxt.Size = new Size(100, 23);
            outputAmtTxt.TabIndex = 1;
            outputAmtTxt.TextChanged += outputAmt_TextChanged;
            // 
            // outputCurrCbb
            // 
            outputCurrCbb.FormattingEnabled = true;
            outputCurrCbb.Location = new Point(6, 22);
            outputCurrCbb.Name = "outputCurrCbb";
            outputCurrCbb.Size = new Size(121, 23);
            outputCurrCbb.TabIndex = 0;
            outputCurrCbb.SelectedIndexChanged += outputCurr_SelectedIndexChanged;
            // 
            // MoneyConverterForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(284, 154);
            Controls.Add(groupBox2);
            Controls.Add(groupBox1);
            Name = "MoneyConverterForm";
            Text = "MoneyConverter";
            groupBox1.ResumeLayout(false);
            groupBox1.PerformLayout();
            groupBox2.ResumeLayout(false);
            groupBox2.PerformLayout();
            ResumeLayout(false);
        }

        #endregion

        private ComboBox inputCurrCbb;
        private GroupBox groupBox1;
        private GroupBox groupBox2;
        private ComboBox outputCurrCbb;
        private TextBox inputAmtTxt;
        private TextBox outputAmtTxt;
    }
}