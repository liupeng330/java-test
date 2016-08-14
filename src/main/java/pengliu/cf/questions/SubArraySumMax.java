package pengliu.cf.questions;

import java.util.Arrays;

/**
 * Created by peng on 8/14/16.
 */
//求数组的连续子序列和的最大值
public class SubArraySumMax
{
    //三重循环, T(N) = O(N^3)
    public static int getMaxSum(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            throw new RuntimeException("");
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i; j<arr.length;j++)
            {
                int sum = 0;
                for(int k=i; k <=j;k++)
                {
                    sum+=arr[k];
                }

                if(sum > max)
                {
                    max = sum;
                }
            }
        }

        return max;
    }

    public static int getMaxSumWithRecursion(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            throw new RuntimeException("");
        }
        return getMaxrecursion(arr, 0, arr.length - 1);
    }

    // 分治法, T(N) = 2T(N/2) + cN, T(N) = O(N*logN)
    private static int getMaxrecursion(int[] arr, int left, int right)
    {
        if(left == right)
        {
            return arr[left];
        }
        if(left > right)
        {
            return Integer.MIN_VALUE;
        }
        int center = (left + right)/2;
        int leftMax = getMaxrecursion(arr, left, center);
        int rightMax = getMaxrecursion(arr, center+1, right);

        int leftHalfMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for(int i=center; i>=left; i--)
        {
            leftSum += arr[i];
            if(leftHalfMax < leftSum)
            {
                leftHalfMax = leftSum;
            }
        }

        int rightHalfMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for(int j = center + 1; j <= right; j++)
        {
            rightSum += arr[j];
            if(rightHalfMax < rightSum)
            {
                rightHalfMax = rightSum;
            }
        }

        return max(leftMax, rightMax, leftHalfMax + rightHalfMax);
    }

    private static int max(int p, int q, int r)
    {
       return (p > q ? p : q) > r ? (p > q ? p : q) : r;
    }


    public static void main(String[] args)
    {
        int[] testArray1 = {1, -2, 3, 5, -3, 2};
        System.out.println(String.format("The test array: %s , max value is %d", Arrays.toString(testArray1), getMaxSum(testArray1)));
        System.out.println(String.format("The test array: %s , max value is %d", Arrays.toString(testArray1), getMaxSumWithRecursion(testArray1)));

        testArray1 = new int[]{0, -2, 3, 5, -1, 2};
        System.out.println(String.format("The test array: %s , max value is %d", Arrays.toString(testArray1), getMaxSum(testArray1)));
        System.out.println(String.format("The test array: %s , max value is %d", Arrays.toString(testArray1), getMaxSumWithRecursion(testArray1)));

        testArray1 = new int[]{-9, -2, -3, -5, -3};
        System.out.println(String.format("The test array: %s , max value is %d", Arrays.toString(testArray1), getMaxSum(testArray1)));
        System.out.println(String.format("The test array: %s , max value is %d", Arrays.toString(testArray1), getMaxSumWithRecursion(testArray1)));
    }
}
