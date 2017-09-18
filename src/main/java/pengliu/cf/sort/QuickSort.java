package pengliu.cf.sort;

import java.util.Arrays;

/**
 * Created by peng on 16-8-2.
 */
public class QuickSort
{
    public static void sort(int[] arr)
    {
        if(arr == null)
        {
            return;
        }
        if(arr.length == 1)
        {
            return;
        }
        Qsort(arr, 0, arr.length - 1);
    }

    private static void Qsort(int[] arr, int left, int right)
    {
        int len = right - left + 1;
        //如果数组只有小于等于3个元素，使用普通排序更快
        if(len <= 3)
        {
            sortForSmallArr(arr, left, right);
            return;
        }

        //开始进行快排
        int pivot = getPivot(arr, left, right);
        int i = left;
        int j = right - 1;
        for(;;)
        {
            while(arr[++i] < pivot){}
            while(arr[--j] > pivot){}
            if(i < j)
            {
                swap(arr, i, j);
            }
            else
            {
                break;
            }
        }
        swap(arr, i, right - 1);
        Qsort(arr, left, i-1);
        Qsort(arr, i+1, right);
    }

    private static int getPivot(int[] arr, int left, int right)
    {
        int center = (left + right)/2;
        if(arr[left] > arr[center])
        {
            swap(arr, left, center);
        }
        if(arr[left] > arr[right])
        {
            swap(arr, left, right);
        }
        if(arr[center] > arr[right])
        {
            swap(arr, center, right);
        }
        swap(arr, center, right - 1);
        return arr[right - 1];
    }

    private static void sortForSmallArr(int[] arr, int left, int right)
    {
        int len = right - left + 1;
        if(len < 2)
        {
            return;
        }
        if(len == 2 && arr[left] > arr[right])
        {
            swap(arr, left, right);
            return;
        }
        if(len == 3)
        {
            int center = (left + right)/2;
            if(arr[left] > arr[center])
            {
                swap(arr, left, center);
            }
            if(arr[left] > arr[right])
            {
                swap(arr, left, right);
            }
            if(arr[center] > arr[right])
            {
                swap(arr, center, right);
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
//        int[] arrBeforeSort = {3, 5, 1, 2, 4};
//        int[] arrBeforeSort = {3, 5, 1};
//        int[] arrBeforeSort = {5, 1};
//        int[] arrBeforeSort = {3, 5, 1, 5, 4};
        int[] arrBeforeSort = {-1, 0, 1, 2, 4, 5};
//        int[] arrBeforeSort = {5, 5, 5, 5, 5};
        System.out.println(String.format("Before sort: %s", Arrays.toString(arrBeforeSort)));
        sort(arrBeforeSort);
        System.out.println(String.format("After sort: %s", Arrays.toString(arrBeforeSort)));
    }
}
