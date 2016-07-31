package pengliu.cf.sort;

import java.util.Arrays;

/**
 * Created by peng on 7/31/16.
 */
public class MergeSort
{
    public static void sort(int[] arr)
    {
        MSort(arr, 0, arr.length-1);
    }

    private static void MSort(int[] arr, int left, int right)
    {
        if(left < right)
        {
            int center = (left + right)/2;
            MSort(arr, left, center);
            MSort(arr, center+1, right);
            Merge(arr, left, center+1, right);
        }
    }

    private static void Merge(int[] arr, int leftStart, int rightStart, int rightEnd)
    {
        int leftEnd = rightStart - 1;
        int len = rightEnd - leftStart + 1;
        int[] temp = new int[len];
        int i = 0;
        int lptr;
        int rptr;
        for(lptr = leftStart, rptr = rightStart; lptr <= leftEnd && rptr <= rightEnd; i++)
        {
            if(arr[lptr] < arr[rptr])
            {
                temp[i] = arr[lptr];
                lptr++;
            }
            else
            {
                temp[i] = arr[rptr];
                rptr++;
            }
        }
        while(lptr <= leftEnd)
        {
            temp[i] = arr[lptr];
            i++;
            lptr++;
        }
        while(rptr <= rightEnd)
        {
            temp[i] = arr[rptr];
            i++;
            rptr++;
        }

        i = 0;
        for(int ptr = leftStart; i < len; i++, ptr++)
        {
            arr[ptr] = temp[i];
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
