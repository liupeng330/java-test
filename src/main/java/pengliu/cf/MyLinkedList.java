package pengliu.cf;

import java.util.Iterator;

/**
 * Created by peng on 10/6/17.
 */
public class MyLinkedList<T> implements Iterable<T> {
    private class Node {
        T value;
        Node next;
    }

    private int N = 0;
    private Node head = null;
    private Node tail = null;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;

        if(isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        N++;
    }

    private Node findPre(T value) {
        Node pre = head;
        Node current = head.next;
        while(current != null) {
            if(current.value.equals(value)) {
                return pre;
            }
            pre = current;
            current = current.next;
        }
        return null;
    }

    public void delete(T value) {
        if(head.value.equals(value)) {
            head = head.next;
            if(N == 1) {
                tail = null;
            }
        }
        else {
            Node pre = findPre(value);
            if(pre == null) return;
            if(pre.next == tail) {
                tail = pre;
            }
            pre.next = pre.next.next;
        }
        N--;
    }

    // 使用私有内部类,隐藏迭代器的实现
    private class LinkedListIterator implements Iterator<T> {
        // 迭代器从链表表头开始遍历
        // 每次使用for each，都会重新初始化一次，都会从表头开始重新遍历
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T temp = current.value;
            current = current.next;
            return temp;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public static void main(String[] args)
    {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        System.out.println(linkedList.size());
        System.out.println(linkedList.isEmpty());
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.printAll();

        linkedList.delete(1);
        linkedList.printAll();

        linkedList.delete(5);
        linkedList.printAll();

        linkedList.delete(123);
        linkedList.printAll();

        linkedList.delete(2);
        linkedList.delete(3);
        linkedList.delete(4);
        linkedList.printAll();

        linkedList.insert(123);
        linkedList.insert(456);
        linkedList.printAll();
    }

    private void printAll() {
        System.out.println("Start to for each");
        for(T i: this)
        {
            System.out.println(i);
        }
    }
}
