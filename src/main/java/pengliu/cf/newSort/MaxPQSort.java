package pengliu.cf.newSort;

import java.util.Arrays;

/**
 * Created by peng on 9/24/17.
 */
public class MaxPQSort {

    public static void main(String[] args) {
        //注意，传入的数组要从1开始，0是没用的
        int[] arr = {-1, 5, 4, 2, 7, 6, 8, 9, 1, 0, 0, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if(arr == null) return;
        int N = arr.length - 1;
        //首先要将数组变为最大堆
        for(int k = N/2; k >= 1; k--) {
            sink(arr, k, N);
        }

        //将当前堆中最大元素放到数组最后，在对N-1个元素重新调整为最大堆
        //不用判断N等于1的情况，因为当N等于2时，在sink中已经比较了N为1和N为2之间的大小了。
        while(N > 1) {
            //将当前堆中最大元素放到数组最后
            swap(arr, 1, N);
            //只把前N-1个元素看做是待调整的堆
            N--;
            //将堆顶元素下沉，让前N-1个元素重新成为最大堆
            sink(arr, 1, N);
        }
    }

    //下沉
    private static void sink(int[] arr, int k, int N) {
        while(2*k <= N) {
            int j = 2*k;

            // 判断j小于N， 而不是j小于等于N， 是为了保证j+1不数组越界
            // 下面的操作是为了当k的子节点有左右两个节点时，保证j是指向更大的那个节点
            if(j < N && arr[j] < arr[j+1]) {
                j++;
            }
            //当arr[k] < arr[j]时，交换k，j的值，并将k下移到该节点
            if(arr[k] < arr[j]) {
                swap(arr, k, j);
                k = j;
            }
            else {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
