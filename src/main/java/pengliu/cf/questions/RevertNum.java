package pengliu.cf.questions;

/**
 * Created by peng on 8/6/16.
 */
public class RevertNum
{
    public static int revert(int num)
    {
        int mark = 1;
        if(num < 0)
        {
            mark = -1;
            num = num * (-1);
        }

        if(num < 10)
        {
            return num * mark;
        }

        int ret = 0;
        while(num != 0)
        {
            ret = ret * 10 + num % 10;
            num = num / 10;
        }

        return ret * mark;
    }

    public static void main(String[] args)
    {
        System.out.println(revert(1));
        System.out.println(revert(12));
        System.out.println(revert(123));
        System.out.println(revert(-123));
    }
}
