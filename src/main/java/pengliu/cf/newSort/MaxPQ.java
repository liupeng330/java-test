package pengliu.cf.newSort;

/**
 * 最大堆
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private int N = 0;
    private Key[] arr;

    public MaxPQ(int maxN) {
        arr = (Key[]) (new Comparable[maxN + 1]);
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N==0;
    }

    //由于完全二叉树的高度是logN (其中N是节点总数)
    //由于上浮就是顺着树往上走，所以移动的次数不会超过树的高度
    //故T(N) = O(logN)
    public void insert(Key value) {
        arr[++N] = value;
        swim(N);
    }

    //同insert，T(N) = O(logN)
    public Key getMax() {
        Key max = arr[1];
        arr[1] = arr[N--];
        sink(1);
        return max;
    }

    //上浮
    private void swim(int k) {
        while(k > 1 && arr[k/2].compareTo(arr[k]) < 0) {
            swap(k/2, k);
            k = k/2;
        }
    }

    //下沉
    private void sink(int k) {
        while(2*k <= N) {
            int j = 2*k;

            // 判断j小于N， 而不是j小于等于N， 是为了保证j+1不数组越界
            // 下面的操作是为了当k的子节点有左右两个节点时，保证j是指向更大的那个节点
            if(j < N && arr[j].compareTo(arr[j+1]) < 0) {
                j++;
            }
            //当arr[k] < arr[j]时，交换k，j的值，并将k下移到该节点
            if(arr[k].compareTo(arr[j]) < 0) {
                swap(k, j);
                k = j;
            }
            else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Key temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(100);
        for(int i = 1; i < 80; i++) {
            pq.insert(i);
        }
        for(int i = 1; i < 80; i++) {
            System.out.println(pq.getMax());
        }
    }
}
