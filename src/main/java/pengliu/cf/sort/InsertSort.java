package pengliu.cf.sort;

import java.util.Arrays;

/**
 * Created by peng on 7/31/16.
 */
public class InsertSort
{
    // T(N) = O(N^2)
    public static void sort(int[] arr)
    {
        if(arr == null) return;
        if(arr.length == 1) return;

        for(int j = 1; j < arr.length; j++)
        {
            int temp = arr[j];
            int i;
            for(i= j-1; i >= 0 && arr[i] > temp;  i--)
            {
                arr[i + 1] = arr[i];
            }
            arr[i + 1] = temp;
        }
    }

    public static void main(String[] args)
    {
        int[] arrBeforeSort = {3, 5, 1, 2, 4};
        System.out.println(String.format("Before sort: %s", Arrays.toString(arrBeforeSort)));
        sort(arrBeforeSort);
        System.out.println(String.format("After sort: %s", Arrays.toString(arrBeforeSort)));
    }
}
