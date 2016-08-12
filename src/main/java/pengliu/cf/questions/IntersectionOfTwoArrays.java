package pengliu.cf.questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by peng on 16-8-10.
 */
public class IntersectionOfTwoArrays
{
    /*
    Given two arrays, write a function to compute their intersection.

    Example:
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

    Note:
    Each element in the result must be unique.
    The result can be in any order.
     */
    public static Integer[] intersection(int[] array1, int[] array2)
    {
        if(array1 == null || array2 == null)
        {
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        for(int i = 0; i < array1.length; i++)
        {
            set1.add(array1[i]);
        }

        Set<Integer> result = new HashSet<>();
        for(int i = 0; i< array2.length; i++)
        {
            if(set1.contains(array2[i]))
            {
                result.add(array2[i]);
            }
        }

        return result.toArray(new Integer[0]);
    }

    public static void main(String[] args)
    {
        int[] array1 = {1, 2, 3, 4, 2, 1, 5, 7, 0};
        int[] array2 = {3, 1, 7, 9, -1, 2};

        Integer[] ret = intersection(array1, array2);

        for(int i = 0; i < ret.length; i++)
        {
            System.out.print(ret[i] + ", ");
        }
        System.out.println();
    }
}
