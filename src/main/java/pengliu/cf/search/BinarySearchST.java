package pengliu.cf.search;

import java.util.LinkedList;
import java.util.Queue;

//使用二分查找算法，来实现查找的常见功能
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    //n用来记录当前表中键值对的个数
    private int n = 0;

    //分别使用两个数组存放键和值
    private Key[] keys;
    private Value[] values;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    //返回小于key的键的数量
    //rank就是一个二分查找算法，故时间复杂度是T(N) = logN
    public int rank(Key key) {
        if(key == null) {
            throw new RuntimeException("Illegal input!!");
        }
        int lo = 0;
        int hi = n - 1;
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            if(key.compareTo(keys[mid]) < 0) {
                hi = mid - 1;
            }
            else if(key.compareTo(keys[mid]) > 0) {
                lo = mid + 1;
            }
            else {
                return mid;
            }
        }
        return lo;
    }

    //向含有N个键值对的表中插入一个新的键值对的复杂度为T(N)=N
    //向一个空表连续插入N个不同的键来构造一个表的时间复杂度为T(N) = N^2, 分析如下：
    //表中有１个元素时插入要比较１次，有2个元素时插入要比较2次，有n个元素时插入要比较n次，
    //n个元素插入一共要比较１＋２＋３...+n次，根据求和公式得 n(1+n)/2 = n^2
    public void put(Key key, Value value) {
        if(key == null || value == null) {
            throw new RuntimeException("Illegal input!!");
        }

        int i = rank(key);
        //表中存在key时，更新value的值
        if(i < n && key.compareTo(keys[i]) == 0) {
            values[i] = value;
        }
        else{
            //不存在时，rank返回的值就是新的键值对应该放置的地方，后面的键值对要向后挪动位置
            for(int j = n; j > i; j--) {
                keys[j] = keys[j-1];
                values[j] = values[j-1];
            }
            //挪动后，将新的值放到该放的位置
            keys[i] = key;
            values[i] = value;
            n++;
        }
    }

    public Value get(Key key) {
        if(key == null || isEmpty()) {
            throw new RuntimeException("Illegal input!!");
        }
        int i = rank(key);
        //表中存在key时，取出value的值
        if(i < n && key.compareTo(keys[i]) == 0) {
            return values[i];
        }
        else{
            return null;
        }
    }

    //返回大于等于key的最小键 (向上取整)
    public Key ceiling(Key key) {
        if(key == null || isEmpty()) {
            throw new RuntimeException("Illegal input!!");
        }
        int i = rank(key);

        //这里需要判断rank是否等于n，等于n就说明传入的key应该排在数组的最后面，
        //最后面的值在数组中就没有比它还大的值了，故要返回null
        //下面说明一下rank返回n的情况
        /*
         要搜索的值为search = 12
         index = 0, 1, 2, 3, 4, 5, 6
         arr   = 1, 3, 4, 6, 7, 9, 11
         lo = 0, hi = 6, mid = 3
         lo = 4, hi = 6, mid = 5
         lo = 6, hi = 6, mid = 6
         lo = 7, hi = 6, mid = 6
         lo > hi, exit from while
         return lo = 7
         最后返回index为7，等于数组大小n
        */

        if(i == n) return null;
        //rank返回的是小于key的元素个数，由于数组下标从0开始，故rank返回的值正好就是ceiling的值
        else return keys[i];
    }

    //返回小于等于key的最大值 (向下取整)
    public Key floor(Key key) {
        if(key == null || isEmpty()) {
            throw new RuntimeException("Illegal input!!");
        }
        int i = rank(key);
        //这里需要判断rank是否等于0，等于0就说明传入的key应该排在数组的最前方，
        //最前面的值在数组中就没有比它还小的值了，故要返回null
        //下面说明一下rank返回n的情况
        /*
         要搜索的值为search = -1
         index = 0, 1, 2, 3, 4, 5, 6
         arr   = 1, 3, 4, 6, 7, 9, 11
         lo = 0, hi = 6, mid = 3
         lo = 0, hi = 2, mid = 1
         lo = 0, hi = 0, mid = 0
         lo = 0, hi = -1, mid = 0
         lo > hi, exit from while
         return lo = 0
         最后返回index为0，等于0
        */
        if(i == 0) return null;
        //这里和ceiling不同，需要判断传入的key是能找到还是不能找到
        //原因和rank的定义有关
        if(i < n && key.compareTo(keys[i]) == 0) return keys[i];
        else return keys[i-1];
    }

    public void delete(Key key) {
        if(key == null || isEmpty()) {
            throw new RuntimeException("Illegal input!!");
        }
        int i = rank(key);
        if(i < n && key.compareTo(keys[i]) == 0) {
            for(int j = i; j < n-1; j++) {
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
            n--;

            //将挪出去的元素置为null，避免总是引用它，导致垃圾回收不能回收它
            keys[n] = null;
            values[n] = null;
        }
    }

    //返回[lo, hi]之间排好序的keys
    public Iterable<Key> keys(Key lo, Key hi) {
        if(lo == null || hi == null) {
            throw new RuntimeException("Illegal input!!");
        }
        Queue<Key> queue = new LinkedList<>();

        //先把[lo, hi)范围的值放入队列中
        for(int i = rank(lo); i < rank(hi); i++){
            queue.add(keys[i]);
        }
        //再判断是否hi在数组中，在则放入结果集中
        if(contains(hi)) {
            queue.add(hi);
        }
        return queue;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    public boolean contains(Key key) {
        int i = rank(key);
        if(i < n && key.compareTo(keys[i]) == 0) {
            return true;
        }
        return false;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[n-1];
    }

    public Key select(int i) {
        return keys[i];
    }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST(100);
        st.put("liu", 1);
        st.put("peng", 2);
        st.put("test", 3);
        st.put("haha", 4);
        st.put("dingdang", 5);
        st.put("heiheiheiw", 6);

        System.out.println("------------------------");
        System.out.println("haha=" + st.get("haha"));

        System.out.println("------------------------");
        System.out.println("size()=" + st.size());

        System.out.println("------------------------");
        for(String key: st.keys()) {
            System.out.println(key);
        }

        System.out.println("------------------------");
        for(String key: st.keys("dz", "lz")) {
            System.out.println(key);
        }

        System.out.println("------------------------");
        for(String key: st.keys("dz", "peng")) {
            System.out.println(key);
        }

        System.out.println("------------------------");
        for(String key: st.keys("a", "z")) {
            System.out.println(key);
        }

        st.delete("test");
        System.out.println("after delete test pengliu/cf/search/BinarySearchST.java:232------------------------");
        for(String key: st.keys()) {
            System.out.println(key);
        }
        System.out.println("------------------------");
        System.out.println("size()=" + st.size());

    }
}
