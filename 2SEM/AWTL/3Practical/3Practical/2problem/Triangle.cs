namespace _3Practical._2problem
{
    internal class Triangle : Shape
    {
        private readonly double _base;
        private readonly double _height;
        public override double Area
        {
            get { return 0.5 * _base * _height; }
        }
        Triangle(double @base, double height)
        {
            _base = @base;
            _height = height;
        }
        public static Triangle Get()
        {
            Console.WriteLine("Enter Triangle's info");
            double @base = Utility.GetDouble("Base: ");
            double height = Utility.GetDouble("Height: ");
            return new(@base, height);
        }
    }
}
