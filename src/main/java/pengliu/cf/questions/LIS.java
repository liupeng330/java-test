package pengliu.cf.questions;

/**
 * Created by peng on 8/13/16.
 */
public class LIS
{
    //T(N) = O(N^2)
    public static int LisWithTwoCircles(int[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            return 0;
        }
        if (arr.length == 1)
        {
            return 1;
        }
        int[] B = new int[arr.length + 1];
        B[1] = arr[0];

        int len = 1;

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] > B[len])
            {
                B[len + 1] = arr[i];
                len++;
            }
            else
            {
                for(int j = 1; j <= len; j++)
                {
                    if(arr[i] < B[j])
                    {
                        B[j] = arr[i];
                        break;
                    }
                }
            }
        }

        return len;
    }

    //T(N) = O(N*logN)
    public static int LisWithBinSearch(int[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            return 0;
        }
        if (arr.length == 1)
        {
            return 1;
        }
        int[] B = new int[arr.length + 1];
        B[1] = arr[0];

        int len = 1;

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] > B[len])
            {
                B[len + 1] = arr[i];
                len++;
            }
            else
            {
                int needToReplaceIndex = binarySearch(B, 1, len, arr[i]);
                B[needToReplaceIndex] = arr[i];
            }
        }

        return len;
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
        return start;
    }

    public static void main(String[] args)
    {
        int[] testArray1 = new int[]{0, -1, 2, 3, 1, 4, 2, 7};
        System.out.println(String.format("LIS is %d", LisWithTwoCircles(testArray1)));
        System.out.println(String.format("LIS is %d", LisWithBinSearch(testArray1)));

        int[] testArray2 = new int[]{-1, 2, 0, 1, 2, 7};
        System.out.println(String.format("LIS is %d", LisWithTwoCircles(testArray2)));
        System.out.println(String.format("LIS is %d", LisWithBinSearch(testArray2)));
    }
}
