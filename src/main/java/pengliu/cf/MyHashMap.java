package pengliu.cf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by peng on 7/21/16.
 */
public class MyHashMap<K, V> {
    private class EntrySet<K, V> {
        private K key;
        private V value;

        public EntrySet(K key, V value) {
            this.setKey(key);
            this.setValue(value);
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj)
        {
            if(obj instanceof EntrySet)
            {
                EntrySet other = (EntrySet)obj;
                return this.getKey().equals(other.getKey()) && this.getValue().equals(other.getValue());
            }
            else
            {
                return false;
            }
        }
    }

    private int size;
    private List<LinkedList<EntrySet<K, V>>> innerList;

    public MyHashMap(int size) {
        this.size = size;
        this.innerList = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            this.innerList.add(new LinkedList<EntrySet<K, V>>());
        }
    }

    private LinkedList<EntrySet<K, V>> getIndex(K key)
    {
        return this.innerList.get(key.hashCode() % this.size);
    }

    private EntrySet<K, V> tryToFindByKey(K key)
    {
        LinkedList<EntrySet<K, V>> linkedList = this.getIndex(key);
        for(EntrySet<K, V> entrySet: linkedList)
        {
            if(entrySet.getKey().equals(key))
            {
                return entrySet;
            }
        }
        return null;
    }

    public void add(K key, V value)
    {
        if(this.tryToFindByKey(key) == null)
        {
            this.getIndex(key).addFirst(new EntrySet<>(key, value));
        }
    }

    public V get(K key)
    {
        EntrySet<K, V> result = this.tryToFindByKey(key);
        if(result != null)
        {
            return result.getValue();
        }
        return null;
    }

    public void remove(K key)
    {
        EntrySet<K, V> result = this.tryToFindByKey(key);
        if(result != null)
        {
            this.getIndex(key).remove(result);
        }
    }

    public static void main(String[] args)
    {
        MyHashMap<String, String> myMap = new MyHashMap<>(5);
        myMap.add("test1", "hahah1");
        myMap.add("test2", "hahah2");
        myMap.add("test3", "hahah3");
        myMap.add("StackUse1", "hahah4");
        myMap.add("test5", "hahah5");
        myMap.add("test6", "hahah6");
        myMap.add("test7", "hahah7");

        System.out.println(myMap.get("test2"));
        System.out.println(myMap.get("test1"));
        myMap.remove("test1");
        System.out.println(myMap.get("test1"));

    }
}

