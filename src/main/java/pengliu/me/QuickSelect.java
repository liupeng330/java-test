package pengliu.me;

/**
 * Created by peng on 8/21/16.
 */
public class QuickSelect
{
    public static Integer quickSelect(int[] arr, int k)
    {
        if(arr == null || arr.length == 0 || arr.length < k || k <= 0)
        {
            return null;
        }

        return qSelect(arr, 0, arr.length - 1, k);
    }

    private static Integer qSelect(int[] arr, int left, int right, int k)
    {
        if(left == right && left + 1 == k)
        {
            return arr[k];
        }
        if(left < right)
        {
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
            if(i+1 == k)
            {
                return arr[i];
            }
            else if(k < i+1)
            {
                return qSelect(arr, left, i-1, k);
            }
            else
            {
                return qSelect(arr, i+1, right, k-i-1);
            }
        }
        return null;
    }

    private static int getPivot(int[] arr, int left, int right)
    {
        int center = (left + right) / 2;
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
        return arr[right -1];
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{3, 1, 2, 4, 0, 5, 7};

        System.out.println(quickSelect(arr, 2));
        System.out.println(quickSelect(arr, 6));
        System.out.println(quickSelect(arr, 5));
    }
}
