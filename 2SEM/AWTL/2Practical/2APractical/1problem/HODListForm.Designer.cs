namespace _2APractical._1problem
{
    partial class HODListForm
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
            hodsLbx = new ListBox();
            label1 = new Label();
            SuspendLayout();
            // 
            // hodsLbx
            // 
            hodsLbx.FormattingEnabled = true;
            hodsLbx.ItemHeight = 15;
            hodsLbx.Location = new Point(12, 45);
            hodsLbx.Name = "hodsLbx";
            hodsLbx.Size = new Size(231, 94);
            hodsLbx.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(54, 9);
            label1.Name = "label1";
            label1.Size = new Size(162, 15);
            label1.TabIndex = 1;
            label1.Text = "HODS available are as follows";
            // 
            // HODListForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(255, 151);
            Controls.Add(label1);
            Controls.Add(hodsLbx);
            Name = "HODListForm";
            Text = "HODListForm";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ListBox hodsLbx;
        private Label label1;
    }
}