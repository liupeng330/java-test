package pengliu.cf.questions;

import java.util.HashSet;

/**
 * Created by peng on 16-8-10.
 */
public class AddDigits
{
    /*
        Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
        For example:
        Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
        Follow up:
        Could you do it without any loop/recursion in O(1) runtime?
    */
    public static int addDigits(int num)
    {
        if(num < 10)
        {
            return num;
        }

        int ret = 0;
        do
        {
            ret = ret + num % 10;
            num = num / 10;
        }
        while(num != 0);

        return addDigits(ret);
    }

    public static void main(String[] args)
    {
        System.out.println(addDigits(9));
        System.out.println(addDigits(10));
        System.out.println(addDigits(38));
        System.out.println(addDigits(123));
    }
}
