package pengliu.cf.test3;

import java.util.*;

/**
 * Created by peng on 16-7-23.
 */
public class test3
{
    public static void main(String[] args)
    {
        Map<String, Integer> map = new HashMap<>();
        map.put("test", 123);
        map.put("test2", 456);
        map.put("test3", 789);

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
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
