package pengliu.cf;

public class BinarySearch
{
    public static int search(int[] array, int searchValue)
    {
        return search(array, searchValue, 0, array.length - 1);
    }

    // T(N) = T(N/2) + c
    // T(N) = O(logN)
    private static int search(int[] array, int searchValue, int left, int right)
    {
        if(array == null)
        {
            throw new RuntimeException("Array is null");
        }
        if(left > right)
        {
            return -1;
        }

        int middle = (left + right) / 2;
        if(array[middle] == searchValue)
        {
            return middle;
        }
        else if(searchValue < array[middle])
        {
            return search(array, searchValue, left, middle - 1);
        }
        else
        {
            return search(array, searchValue, middle + 1, right);
        }
    }

    public static void main(String[] args)
    {
        int[] array = {2, 4, 5, 7, 9, 10, 14, 16};
        System.out.println("The index of found value in array is " + BinarySearch.search(array, 16));
        System.out.println("The index of found value in array is " + BinarySearch.search(array, 13));
    }
}
