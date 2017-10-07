package pengliu.cf;

import java.util.Iterator;

/**
 * Created by peng on 10/7/17.
 */
public class MyDoubleLinkedList<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator implements Iterator<T> {
        private Node current = head;
        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T temp = current.value;
            current = current.next;
            return temp;
        }
    }

    private class Node {
        T value;
        Node next;
        Node pre;
    }

    private Node head = null;
    private Node tail = null;
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void addFirst(T value) {
        Node temp = new Node();
        temp.value = value;
        temp.next = head;
        temp.pre = null;

        if(isEmpty()) {
            tail = temp;
        }
        else {
            head.pre = temp;
        }
        head = temp;
        n++;
    }

    public void addLast(T value) {
        Node temp = new Node();
        temp.value = value;
        temp.next = null;
        temp.pre = tail;

        if(isEmpty()) {
            head = temp;
        }
        else {
            tail.next = temp;
        }
        tail = temp;
        n++;
    }

    public T removeFirst() {
        if(isEmpty()) return null;
        T temp = head.value;
        if(n == 1) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.pre = null;
        }
        n--;
        return temp;
    }

    public T removeLast() {
        if(isEmpty()) return null;
        T temp = tail.value;
        if(n == 1) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.pre;
            tail.next = null;
        }
        n--;
        return temp;
    }

    public void remove(T value) {
        for(Node cur = head; cur != null; cur = cur.next) {
            if(cur.value.equals(value)) {
                if(cur == head) {
                    removeFirst();
                }
                else if(cur == tail) {
                    removeLast();
                }
                else {
                    cur.pre.next = cur.next;
                    cur.next.pre = cur.pre;
                }
                return;
            }
        }
    }

    //翻转链表
    public void revert() {
        if(n <= 1) return;

        for(Node cur = head; cur != null; cur = cur.pre) {
            swap(cur);
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

    private void swap(Node a) {
        Node temp = a.next;
        a.next = a.pre;
        a.pre = temp;
    }

    private void printAll() {
        System.out.println("Start to for each");
        for(T i: this)
        {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyDoubleLinkedList<Integer> doubleLinkedList = new MyDoubleLinkedList<>();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(4);
        doubleLinkedList.addFirst(5);
        doubleLinkedList.printAll();

        doubleLinkedList.addLast(6);
        doubleLinkedList.addLast(7);
        doubleLinkedList.addLast(8);
        doubleLinkedList.printAll();

        System.out.println("remove first");
        System.out.println(doubleLinkedList.removeFirst());
        System.out.println(doubleLinkedList.removeFirst());
        System.out.println(doubleLinkedList.removeFirst());
        doubleLinkedList.printAll();

        System.out.println("remove first");
        System.out.println(doubleLinkedList.removeFirst());
        System.out.println(doubleLinkedList.removeFirst());
        System.out.println(doubleLinkedList.removeFirst());
        System.out.println(doubleLinkedList.removeFirst());
        System.out.println(doubleLinkedList.removeFirst());
        System.out.println(doubleLinkedList.removeFirst());
        doubleLinkedList.printAll();

        System.out.println("size()=" + doubleLinkedList.size());
        System.out.println("remove last");
        System.out.println(doubleLinkedList.removeLast());
        doubleLinkedList.printAll();

        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        System.out.println("remove last");
        System.out.println(doubleLinkedList.removeLast());
        doubleLinkedList.printAll();

        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(4);
        doubleLinkedList.addFirst(5);
        doubleLinkedList.printAll();

        System.out.println("Revert");
        doubleLinkedList.revert();
        doubleLinkedList.printAll();

        System.out.println("Remove 1");
        doubleLinkedList.remove(1);
        doubleLinkedList.printAll();
    }
}
