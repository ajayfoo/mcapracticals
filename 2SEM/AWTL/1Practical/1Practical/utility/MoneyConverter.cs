using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2Practical.utility
{
    internal class MoneyConverter
    {
        private static double ToINR(Currency srcCurr, double srcAmt)
        {
            switch(srcCurr)
            {
                case Currency.USD: return srcAmt * 82.04;
                case Currency.YEN: return srcAmt * 0.62;
                case Currency.EUR: return srcAmt * 89.81;
                default: return srcAmt;
            }
        }
        private static double INRTo(Currency destCurr,double srcAmt)
        {
            switch (destCurr)
            {
                case Currency.USD: return srcAmt * 0.012;
                case Currency.YEN: return srcAmt * 1.60;
                case Currency.EUR: return srcAmt * 0.011;
                default: return srcAmt;
            }
        }
        public static double convert(Currency srcCurr,Currency destCurr,double srcAmt)
        {
            if (srcCurr == destCurr) return srcAmt;
            double inrsrcAmt=ToINR(srcCurr,srcAmt);
            return INRTo(destCurr,inrsrcAmt);
        }
    }
}
