using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Linq;
using System.ServiceProcess;
using System.Text;

namespace Practical9B
{
    partial class Service1 : ServiceBase
    {
        public Service1()
        {
            InitializeComponent();
        }

        protected override void OnStart(string[] args)
        {
            // TODO: Add code here to start your service.
        }

        protected override void OnStop()
        {
            // TODO: Add code here to perform any tear-down necessary to stop your service.
        }
        public int Addition(int num1, int num2)
        {
            return num1 + num2;
        }
        public int Subtraction(int num1, int num2)
        {
            return num1 - num2;
        }
        public int Multiplication(int num1, int num2)
        {
            return num1 * num2;
        }
        public int Division(int num1, int num2)
        {
            return num1 / num2;
        }
    }
}
