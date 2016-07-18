package pengliu.cf.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
/**
 * Created by peng on 7/9/16.
 */
public class test
{
    public static void main(String[] args)
    {
        Collection<Integer> testCollection = Arrays.asList(1, 2, 3, 4);
        System.out.println(testCollection.size());
//        System.out.println(testCollection.add(6));
        Integer[] array = {1, 2, 3, 4};
        Collection<Integer> testCollection2 = new ArrayList<Integer>(Arrays.asList(array));

        for(Integer i: testCollection2)
        {
            System.out.println(i);
        }
    }
}
