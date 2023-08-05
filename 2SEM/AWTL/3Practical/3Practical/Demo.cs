using _3Practical._1problem;
using _3Practical._2problem;

namespace _3Practical
{
    internal class Demo
    {
        internal static class Problem1
        {
            public static void Run()
            {
                Console.WriteLine("Running Problem No.1 Demo...");
                Result.Get().ShowInfo();
            }
        }
        internal static class Problem2
        {
            public static void Run()
            {
                Console.WriteLine("Running Problem No.2 Demo...");
                Console.WriteLine("Area of Circle: " + Circle.Get().Area);
                Console.WriteLine("Area of Ellipse: " + Ellipse.Get().Area);
                Console.WriteLine("Area of Rectangle: " + Rectangle.Get().Area);
                Console.WriteLine("Area of Triangle: " + Triangle.Get().Area);
            }
        }
    }
}