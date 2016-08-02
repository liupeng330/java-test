package pengliu.cf.sort;

import java.util.Arrays;

/**
 * Created by peng on 16-8-2.
 */
public class QuickSelect
{
    // 表示找数组arr中第k个小的值
    public static Integer quickSelect(int[] arr, int k)
    {
        if(arr == null) return null;

        if(arr.length == 1)
        {
            // 如果数组中只有一个元素并且只要返回第1个小的值，就返回此元素即可
            if(k == 1)
            {
                return arr[0];
            }
            //否则返回空
            else
            {
                return null;
            }
        }
        return Qselect(arr, k, 0, arr.length - 1);
    }

    // T(N) = T(N/2) + N
    // T(N) = O(NlogN)
    public static Integer Qselect(int[] arr, int k, int left, int right)
    {
        int len = right - left + 1;
        if(len <= 3)
        {
            return selectForSmallArr(arr, k, left, right);
        }
        int pivot = getPivot(arr, left, right);
        int i = left;
        int j = right - 1;
        for(;;)
        {
            while(arr[++i] < pivot) {}
            while(arr[--j] > pivot) {}
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
        if(k - 1 == i)
        {
            return arr[i];
        }
        else if(k - 1 < i)
        {
            return Qselect(arr, k, left, i - 1);
        }
        else
        {
            return Qselect(arr, k - i - 1, i + 1, right);
        }
    }

    private static Integer selectForSmallArr(int[] arr, int k, int left, int right)
    {
        int len = right - left + 1;
        if(len == 1 && k == 1)
        {
            return arr[left];
        }
        //长度为2的数组， 找第2个以上小的时候，返回空
        if(len == 2)
        {
            if(k > 2)
            {
                return null;
            }
            else if(arr[left] > arr[right])
            {
                swap(arr, left, right);
            }
            return arr[left + k - 1];
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

            return arr[left + k - 1];
        }
        return null;
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

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] arrBeforeSort = {3, 5, 1, 5, 4};
        System.out.println("求数组中第1个最小值: " + quickSelect(arrBeforeSort, 1));

        arrBeforeSort = new int[]{3, 5, 1, 5, 4};
        System.out.println("求数组中第2个最小值: " + quickSelect(arrBeforeSort, 2));

        arrBeforeSort = new int[]{3, 5, 1, 5, 4};
        System.out.println("求数组中第3个最小值: " + quickSelect(arrBeforeSort, 3));

        arrBeforeSort = new int[]{3, 5, 1, 5, 4};
        System.out.println("求数组中第4个最小值: " + quickSelect(arrBeforeSort, 4));

        arrBeforeSort = new int[]{3, 5, 1, 5, 4};
        System.out.println("求数组中第5个最小值: " + quickSelect(arrBeforeSort, 5));

        arrBeforeSort = new int[]{3, 1, 4, 2, 5, 7, 0, 2, 0};
        System.out.println(String.format("求数组'%s'中第'%s'个最小值: %s",
                Arrays.toString(arrBeforeSort), 6, quickSelect(arrBeforeSort, 6)));
    }
}
