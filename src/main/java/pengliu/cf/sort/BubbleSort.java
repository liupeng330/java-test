package pengliu.cf.sort;

import java.util.Arrays;

/**
 * Created by peng on 7/31/16.
 */
public class BubbleSort
{
    public static void sort(int[] arr)
    {
        if(arr == null)
        {
            return;
        }

        if(arr.length == 0)
        {
            return;
        }

        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[i] > arr[j])
                {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] arrBeforeSort = {3, 5, 1, 2, 4};
        System.out.println(String.format("Before sort: %s", Arrays.toString(arrBeforeSort)));
        sort(arrBeforeSort);
        System.out.println(String.format("After sort: %s", Arrays.toString(arrBeforeSort)));
    }
}
