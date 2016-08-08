package pengliu.cf.questions;

/**
 * Created by peng on 8/8/16.
 */
public class RevertSentence
{
    public static String revert(String input)
    {
        if(input == null || input.length() <= 1)
        {
            return input;
        }

        // first, swap all
        char[] arr = input.toCharArray();
        for(int i = 0, j = arr.length - 1; i<=j; i++, j--)
        {
            swap(arr, i, j);
        }

        //then, swap by word
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == ' ')
            {
                endIndex = i-1;
                swapWord(arr, startIndex, endIndex);
                startIndex = i+1;
            }
        }

        return new String(arr);
    }

    private static void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swapWord(char[] arr, int start, int end)
    {
        for(int i = start, j = end; i<=j; i++, j--)
        {
            swap(arr, i, j);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(revert("I love java"));
    }
}
