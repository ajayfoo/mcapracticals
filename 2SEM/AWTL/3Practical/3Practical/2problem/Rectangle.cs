namespace _3Practical._2problem
{
    internal class Rectangle : Shape
    {
        private readonly double _length;
        private readonly double _breadth;
        public override double Area
        {
            get { return _length * _breadth; }
        }
        Rectangle(double length, double breadth)
        {
            _length = length;
            _breadth = breadth;
        }
        public static Rectangle Get()
        {
            Console.WriteLine("Enter Rectangle's info.");
            double length = Utility.GetDouble("Length: ");
            double breadth = Utility.GetDouble("Breadth: ");
            return new(length, breadth);
        }
    }
}
