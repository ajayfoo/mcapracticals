namespace _3Practical._2problem
{
    internal class Ellipse : Shape
    {
        private readonly double _majAxisLength;
        private readonly double _minAxisLength;
        private double  SemiMajorAxisLength { get { return _majAxisLength / 2; } }
        private double SemiMinorAxisLength { get { return _minAxisLength / 2; } }
        public override double Area
        {
            get
            {
                return Math.PI * SemiMajorAxisLength * SemiMinorAxisLength;
            }
        }
        public Ellipse(double majAxisLength, double minAxisLength)
        {
            _majAxisLength = majAxisLength;
            _minAxisLength = minAxisLength;
        }
        public static Ellipse Get()
        {
            Console.WriteLine("Enter Ellipse's info.");
            double majAxisLength = Utility.GetDouble("Major Axis Length: ");
            double minAxisLength = Utility.GetDouble("Minor Axis Length: ");
            return new(majAxisLength, minAxisLength);
        }
    }
}
