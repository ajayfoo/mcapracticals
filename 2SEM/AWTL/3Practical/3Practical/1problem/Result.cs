namespace _3Practical._1problem
{
    internal class Result : Test
    {
        int _total;
        public int Total { get => _total; set => _total = value; }
        internal Result(int rollNo, string name, int marks1, int marks2) : base(rollNo, name, marks1, marks2)
        {
            Total = marks1 + marks2;
        }
        public void ShowInfo()
        {
            Console.WriteLine($"Student's Info:-\nRoll No.: {RollNo}, Name: {Name}, Marks 1: {Marks1}, Marks 2: {Marks2}, Total: {Total}");
        }
        public static Result Get()
        {
            Console.WriteLine("Enter Student's info:-");
            int rollNo = Utility.GetInt("Roll No.: ");
            string name = Utility.GetString("Name: ");
            int marks1 = Utility.GetInt("Marks1: ");
            int marks2 = Utility.GetInt("Marks2: ");
            return new(rollNo, name, marks1, marks2);
        }
    }
}
