namespace _2Practical
{
    partial class TemperatureConverterForm
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
            fhrnTxt = new TextBox();
            celsTxt = new TextBox();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(63, 15);
            label1.TabIndex = 0;
            label1.Text = "Fahrenheit";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(12, 46);
            label2.Name = "label2";
            label2.Size = new Size(44, 15);
            label2.TabIndex = 1;
            label2.Text = "Celsius";
            // 
            // fhrnTxt
            // 
            fhrnTxt.Location = new Point(95, 6);
            fhrnTxt.Name = "fhrnTxt";
            fhrnTxt.Size = new Size(100, 23);
            fhrnTxt.TabIndex = 2;
            fhrnTxt.TextChanged += fhrnTxt_TextChanged;
            // 
            // celsTxt
            // 
            celsTxt.Location = new Point(95, 43);
            celsTxt.Name = "celsTxt";
            celsTxt.Size = new Size(100, 23);
            celsTxt.TabIndex = 3;
            celsTxt.TextChanged += celsTxt_TextChanged;
            // 
            // TemperatureConverterForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(237, 74);
            Controls.Add(celsTxt);
            Controls.Add(fhrnTxt);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "TemperatureConverterForm";
            Text = "TemperatureConverterForm";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private TextBox fhrnTxt;
        private TextBox celsTxt;
    }
}