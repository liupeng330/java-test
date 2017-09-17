package pengliu.cf.newSort;

import java.util.Arrays;

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

    private static int partition(int[] a, int low, int high) {
        int p = getPivot(a, low, high);
        int i= low + 1;
        int j = high;
        while(true) {
            while(a[++i] < p) {}
            while(a[--j] > p) {}
            if(i > j) break;
            exchange(a, i, j);
        }
        exchange(a, low+1, j);
        return j;
    }

    private static int getPivot(int[] a, int start, int end) {
        int mid = (start + end) / 2;
        if(a[start] > a [mid]) {
            exchange(a, start, mid);
        }
        if(a[mid] > a [end]) {
            exchange(a, end, mid);
        }
        if(a[start] > a [mid]) {
            exchange(a, start, mid);
        }
        exchange(a, start + 1, mid);
        return a[start + 1];
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int quickSelect(int[] a, int k, int start, int end) {
        if(start == end) {
            return a[start];
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

    public static int quickSelect(int[] a, int k) {
        if(a.length == 1) {return a[0];}
        if(a.length == 2) {
            if(a[0] > a[1]) {
                exchange(a, 0, 1);
            }
            return a[k-1];
        }

        return quickSelect(a, k, 0, a.length - 1);
    }
}
