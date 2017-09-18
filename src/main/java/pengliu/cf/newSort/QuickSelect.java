package pengliu.cf.newSort;

/**
 * Created by peng on 9/17/17.
 */
public class QuickSelect {
    public static void main(String[] args) {
        int[] input = {4, 1, 5, 0, 2, -1};
        for(int k=1; k<=input.length; k++) {
            System.out.println("For k=" + k + ", quick select is " + quickSelect(input, k));
        }

        input = new int[]{6, 5};
        System.out.println(quickSelect(input, 1));
    }

    public static int quickSelect(int[] a, int k) {
        if(a == null) {
            throw new RuntimeException("Array object can not be NULL!!");
        }
        if(k > a.length) {
            throw new RuntimeException("The k is out of range!!");
        }
        if(a.length == 1) {
            return a[0];
        }
        return quickSelect(a, k, 0, a.length - 1);
    }

    // 最好的情况，平均分配左右两堆，那么T(N) = T(N/2) + cN
    // 不断将T(N/2^i)带入上面的公式： T(N)= T(N/2^2) + cN/2 + cN
    //                               = T(N/2^3) + cN/2^2 + cN/2 + cN
    //                               = T(1) + c2 + .... + cN/2^i +.... + cN/2^2 + cN/2 + cN
    //                               = T(1) + c2 + .... + cN/2^2 + cN/2 + cN   (当i等于logN时，N/2^i等于1)
    //                               = T(1) + cN(1 + 1/2 + 1/2^2 + ... + 1/2^(logN)) (利用等比数列求和公式，比数q为1/2，n为logN)
    //                               = T(1) + cN(2 * (1-(1/2)^logN))
    //                               = T(1) + cN(2 -2/N)
    //                               = T(1) + 2cN -2c
    //                               = O(N)
    private static int quickSelect(int[] a, int k, int start, int end) {
        int len = end - start + 1;
        if(len <= 3) {
            return selectForSmall(a, k, start, end);
        }
        int p = partition(a, start, end);
        if(k-1 < p) {
            return quickSelect(a, k, start, p - 1);
        }
        else if(p < k-1) {
            return quickSelect(a, k, p + 1, end);
        }
        else {
            return a[k-1];
        }
    }

    private static int selectForSmall(int[] a, int k, int start, int end) {
//        if(start >= end) {
//            return;
//        }
        int len = end - start + 1;
        if(len == 2) {
            if(a[start] > a[end]) {
                swap(a, start, end);
            }
        }
        if(len == 3) {
            int mid = start + 1;
            if(a[start] > a[mid]) {
                swap(a, start, mid);
            }
            if(a[mid] > a[end]) {
                swap(a, mid, end);
            }
            if(a[start] > a[mid]) {
                swap(a, start, mid);
            }
        }

        //also cover when start == end
        return a[k-1];
    }

    private static int partition(int[] a, int low, int high) {
        int p = getPivot(a, low, high);
        int i= low + 1;
        int j = high;
        while(true) {
            while(a[++i] < p) {}
            while(a[--j] > p) {}
            if(i > j) break;
            swap(a, i, j);
        }
        swap(a, low+1, j);
        return j;
    }

    private static int getPivot(int[] a, int start, int end) {
        int mid = (start + end) / 2;
        if(a[start] > a [mid]) {
            swap(a, start, mid);
        }
        if(a[mid] > a [end]) {
            swap(a, end, mid);
        }
        if(a[start] > a [mid]) {
            swap(a, start, mid);
        }
        swap(a, start + 1, mid);
        return a[start + 1];
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
