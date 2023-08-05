using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3Practical._1problem
{
    internal class Student
    {
        private int _rollNo;
        private string _name = string.Empty;

        public int RollNo
        {
            get { return _rollNo; }
            set { _rollNo = value; }
        }
        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }
        internal Student(int rollNo, string name)
        {
            RollNo = rollNo;
            Name = name;
        }

    }
}
