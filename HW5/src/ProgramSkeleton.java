import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramSkeleton {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramSkeleton() {
    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {
        String input;
        int buffer = 0;
        int number = 0;
        boolean hasInt;
        while (number <= 0) {
            out.print("Enter a positive number");
            input = in.nextLine();
            hasInt = FormatChecker.canParseInt(input);
            if (hasInt) {
                buffer = Integer.parseInt(input);
                if (buffer > 0) {
                    number = buffer;
                }
            }
        }
        return number;
    }

    private static int evenSum() {
        int sum = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum += i;
        }
        return sum;
    }

    private static int sqareSum() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i * i;
        }
        return sum;
    }

    private static int powerSum() {
        int sum = 0;

        for (int i = 0; i <= 20; i++) {
            int val = 1;
            for (int j = 0; j < i; j++) {
                val *= 2;
            }
            sum += val;
        }
        return sum;
    }

    private static int oddSum(int a, int b) {
        int sum = 0;
        if (a % 2 == 0) {
            a++;
        }
        if (b % 2 == 0) {
            b--;
        }
        for (int i = a; i <= b; i += 2) {
            sum += i;
        }
        return sum;
    }

    private static int oddDigitSum(int num) {
        int sum = 0;
        String str;
        str = Integer.toString(num);
        for (int i = str.length() - 1; i >= 0; i -= 2) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }

    private static int oddDigitSum2(int num) {
        int sum = 0;
        String str;
        str = Integer.toString(num);
        for (int i = 0; i < str.length(); i += 2) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }

    /**
     * Computing the larger of two integers
     *
     * @param a
     *            the first number
     * @param b
     *            the second number
     * @return the larger number
     */
    private static int largerInt(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * Computing the smallest of three real numbers
     *
     * @param a
     *            the first number
     * @param b
     *            the second number
     * @param c
     *            the third number
     * @return the biggest number
     */
    private static double smallerstNum(double a, double b, double c) {
        double biggest = a;
        biggest = biggest < b ? b : biggest;
        biggest = biggest < c ? c : biggest;
        return biggest;
    }

    /**
     * Checking whether an integer is a prime number, returning true if it is
     * and false otherwise
     *
     * @param num
     *            input number to check if it is a prime
     * @return a boolean shows if it is a prime number
     */
    private static boolean isPrime(int num) {
        boolean isPrime = true;
        for (int i = 2; i < num; i++) {
            isPrime = num % i == 0 ? false : true;
        }
        if (num == 1 || num == 0) {
            isPrime = false;
        }
        return isPrime;
    }

    /**
     * Checking whether a string of characters is contained inside another
     * string of characters
     *
     * @param str1
     *            the original string
     * @param str2
     *            the sub-string that need to be check
     * @return a boolean shows if the substring is found in the original string
     */
    private static boolean containString(String str1, String str2) {
        boolean isContain = str1.indexOf(str2) == -1 ? false : true;
        return isContain;
    }

    /**
     * Computing the balance of an account with a given initial balance, an
     * annual interest rate, and a number of years of earning interest
     *
     * @param initBalance
     *            the initial balance
     * @param interestRate
     *            the rate of interest(not in percentage)
     * @param year
     *            how many year(s)
     * @return the calculated balance after given year(s)
     */
    private static double balance(double initBalance, double interestRate,
            double year) {
        double balance = initBalance;
        for (int i = 0; i < year; i++) {
            balance += balance * (1 + interestRate);
        }
        return balance;
    }

    /**
     * Printing the balance of an account with a given initial balance and an
     * annual interest rate over a given number of years
     *
     * @param initBalance
     *            the initial balance
     * @param interestRate
     *            the rate of interest(not in percentage)
     * @param year
     *            how many year(s)
     * @param out
     *            the output object
     */
    private static void balance(double initBalance, double interestRate,
            double year, SimpleWriter out) {
        double balance = initBalance;
        for (int i = 0; i < year; i++) {
            balance += balance * (1 + interestRate);
        }
        out.println("After " + year + " years, the avaliable balance will be "
                + balance);
    }

    /*
     * private static int generateRandomInt(int range) { double rawRand; Random
     * rand = new Random1L(); rawRand = rand.nextDouble(); }
     */

    public static boolean allTheSame(int x, int y, int z) {
        return x == y && y == z ? true : false;
    }

    public static boolean allDifferent(int x, int y, int z) {
        return x != y && y != z && x != z ? true : false;
    }

    public static boolean sorted(int x, int y, int z) {
        return x <= y && y <= z ? true : false;
    }

    /**
     * Printing the calendar for a given month and year
     *
     * @param month
     *            the month you want to print
     * @param year
     *            the year of the month
     * @param out
     *            the print to screen object
     */
    public static void printCalendar(int year, int month, SimpleWriter out) {

    }

    /**
     * Computing the weekday for a given day, month, and year (as a string such
     * as "Monday")
     *
     * @param year
     *            the year of the date
     * @param month
     *            the month of the date
     * @param day
     *            the day of the date
     *
     * @return a string showing which weekday the given day is
     */
    public static String computeWeekday(int year, int month, int day) {
        String weekday[] = { "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday" };
        int i = 0;

        return weekday[i];
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        boolean notSame = sorted(1, 2, 3);
        out.println(notSame);
        boolean allSame = sorted(1, 2, 1);
        out.print(allSame);
    }

}
