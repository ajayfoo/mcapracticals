using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2APractical._1problem
{
    internal class Staff
    {
        public string Name { get; private set; }
        public Post Post { get; private set; }

        internal Staff(string name,Post post)
        {
            this.Name = name;
            this.Post = post;
        }

    }
}
