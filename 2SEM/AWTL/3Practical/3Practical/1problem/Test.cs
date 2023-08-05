using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3Practical._1problem
{
    internal class Test : Student
    {
        private int _marks1, _marks2;
        public int Marks1 { get => _marks1; set => _marks1 = value; }
        public int Marks2 { get => _marks2; set => _marks2 = value; }
        internal Test(int rollNo, string name, int marks1, int marks2) : base(rollNo, name)
        {
            Marks1 = marks1;
            Marks2 = marks2;
        }
    }
}
