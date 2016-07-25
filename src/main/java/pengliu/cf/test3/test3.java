package pengliu.cf.test3;

/**
 * Created by peng on 16-7-23.
 */
public class test3
{
    public static void main(String[] args)
    {
        System.out.println(cal(10));
    }

    private static int cal(int x)
    {
        if(x == 1)
        {
            return 1;
        }
        else
        {
            return x * cal(x - 1);
        }
    }
}
