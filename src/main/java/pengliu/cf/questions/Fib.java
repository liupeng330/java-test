package pengliu.cf.questions;

/**
 * Created by peng on 8/7/16.
 */
public class Fib
{
    public static int Fib(int n)
    {
        if(n <= 1)
        {
            return 1;
        }
        return Fib(n-1) + Fib(n-2);
    }

    public static int FibWithoutRecursion(int n)
    {
        if(n < 0 ) return 0;
        if(n <= 1) return 1;

        int current = 2;
        int last = 1;
        int nextToLast = 1;
        int result = 0;

        while(current <= n)
        {
            result = last + nextToLast;
            nextToLast = last;
            last = result;
            current++;
        }

        return result;
    }

    public static void main(String[] args)
    {
        for(int i = 0; i < 10; i++)
        {
            System.out.print(Fib(i) + ", " );
        }
        System.out.println();

        for(int i = 0; i < 10; i++)
        {
            System.out.print(FibWithoutRecursion(i) + ", " );
        }
        System.out.println();
    }
}
