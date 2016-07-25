package pengliu.cf.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2
{
    public static void main(String[] args)
    {
        String[] arr = {"aa", "bb", "cc"};
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        list.add("dd");
        for(String s: list)
        {
            System.out.println(s);
        }

        List<String> list2 = Arrays.asList(arr);
        list2.add("dd");
        for(String s: list2)
        {
            System.out.println(s);
        }

    }
}
