namespace _3Practical
{
    internal class Utility
    {
        public static int GetInt(string message)
        {
            while (true)
            {
                Console.Write(message);
                try
                {
                    return Convert.ToInt32(Console.ReadLine());
                }
                catch (FormatException)
                {
                    Console.WriteLine("Please enter a valid integer.");
                    continue;
                }
            }
        }
        public static double GetDouble(string message)
        {
            while (true)
            {
                Console.Write(message);
                try
                {
                    return Convert.ToDouble(Console.ReadLine());
                }
                catch (FormatException)
                {
                    Console.WriteLine("Please enter a valid real number.");
                    continue;
                }
            }
        }
        public static string GetString(string message)
        {
            Console.Write(message);
            return Console.ReadLine() ?? string.Empty;
        }
    }
}
