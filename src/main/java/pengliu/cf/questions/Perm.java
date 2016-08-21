package pengliu.cf.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by peng on 8/21/16.
 */
//全排列的递归实现
//全排列是将一组数按一定顺序进行排列,如果这组数有 n 个,那么全排列数为 n!个。
public class Perm
{
    public static List<Integer[]> getPerm(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            return null;
        }
        List<Integer[]> ret = new ArrayList<>();
        if(arr.length == 1)
        {
            ret.add(new Integer[]{arr[0]});
            return ret;
        }

        for(int i=0; i<arr.length; i++)
        {
            swap(arr, i, 0);
            List<Integer[]> perm = getPerm(getNewArray(arr));
            for(Integer[] arrRet: perm)
            {
                ret.add(insertToArrayAsHead(arr[0], arrRet));
            }
        }

        return ret;
    }

    private static int[] getNewArray(int[] arr)
    {
        int[] newArr = new int[arr.length - 1];
        for(int i=1; i<arr.length; i++)
        {
            newArr[i-1] = arr[i];
        }
        return newArr;
    }

    private static Integer[] insertToArrayAsHead(Integer head, Integer[] arr)
    {
        Integer[] newArr = new Integer[arr.length + 1];

        newArr[0] = head;
        for(int i=0; i<arr.length; i++)
        {
            newArr[i+1] = arr[i];
        }

        return newArr;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        List<Integer[]> perm = getPerm(new int[]{1, 2, 3, 4});

        for(Integer[] arr: perm)
        {
            System.out.println(Arrays.toString(arr));
        }
    }
}
