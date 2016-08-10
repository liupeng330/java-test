package pengliu.cf.questions;

/**
 * Created by peng on 16-8-10.
 */
public class SumOfTwoIntegers
{
    public static int getSum(int a, int b)
    {
        int ret = 0;
        if(a < 0)
        {
            while(a != 0)
            {
                a++;
                ret--;
            }
        }
        else
        {
            while(a != 0)
            {
                a--;
                ret++;
            }
        }

        if(b < 0)
        {
            while(b != 0)
            {
                b++;
                ret--;
            }
        }
        else
        {
            while(b != 0)
            {
                b--;
                ret++;
            }
        }

        return ret;
    }

    public static void main(String[] args)
    {
        System.out.println(getSum(123, 456));
        System.out.println(getSum(-123, 456));
        System.out.println(getSum(-123, -456));
    }
}
