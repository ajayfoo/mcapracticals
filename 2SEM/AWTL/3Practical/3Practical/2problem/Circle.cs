
namespace _3Practical._2problem
{
    internal class Circle : Shape
    {
        private readonly double _radius;
        public override double Area
        {
            get { return Math.PI * Math.Pow(_radius, 2); }
        }
        public Circle(double radius)
        {
            _radius = radius;
        }
        public static Circle Get()
        {
            Console.WriteLine("Enter Circle's info.");
            double radius = Utility.GetDouble("Radius: ");
            return new(radius);
        }
    }
}
