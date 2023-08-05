using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2APractical._2problem
{
    internal class Salary
    {
        decimal basic;
        byte ta;
        byte da;
        byte hra;
        internal Salary(decimal basic,byte ta, byte da=20, byte hra=50)
        {
            this.basic = basic;
            this.ta = ta;
            this.da = da;
            this.hra=hra;
        }
        private decimal PercentOfBasic(byte rate)
        {
            return (basic*rate)/100;
        }
        public decimal get()
        {
            return basic + PercentOfBasic(ta) + PercentOfBasic(da) + PercentOfBasic(hra);
        }
    }
}
