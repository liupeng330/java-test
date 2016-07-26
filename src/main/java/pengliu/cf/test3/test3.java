package pengliu.cf.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by peng on 16-7-23.
 */
public class test3
{
    public static void main(String[] args)
    {
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
