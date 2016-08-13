package pengliu.cf.questions;

/**
 * Created by peng on 8/13/16.
 */
public class BinarySearch
{
    //T(N) = T(N/2) + c
    //T(N) = O(logN)
    public static int BinSearch(int[] arr, int search)
    {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }
        if(arr.length == 1)
        {
            if(arr[0] == search)
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
        return binarySearch(arr, 0, arr.length - 1, search);
    }

    private static int binarySearch(int[] arr, int start, int end, int search)
    {
        if(start <= end)
        {
            int center = (start + end) / 2;
            if(arr[center] == search)
            {
                return center;
            }
            else if(search < arr[center])
            {
                return binarySearch(arr, start, center - 1, search);
            }
            else
            {
                return binarySearch(arr, center + 1, end, search);
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] test = {2, 4, 6, 8, 10, 12, 14};
        System.out.println(BinSearch(test, 12));
        System.out.println(BinSearch(test, 2));
        System.out.println(BinSearch(test, 5));
    }
}
