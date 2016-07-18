package pengliu.cf;

import java.util.Iterator;

/**
 * Created by peng on 7/18/16.
 */
public class MyLinkedList<T>
{
    private static class Node<U>
    {
        private Node<U> next;
        private U value;

        public Node(Node<U> next, U value)
        {
            this.setNext(next);
            this.setValue(value);
        }

        public Node<U> getNext() {
            return next;
        }

        public void setNext(Node<U> next) {
            this.next = next;
        }

        public U getValue() {
            return value;
        }

        public void setValue(U value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public boolean isEmpty()
    {
        return this.head == null && this.tail == null;
    }

    public int size()
    {
        if(this.isEmpty())
        {
            return 0;
        }
        int size = 0;
        for(Node<T> cur = this.head; cur != null; cur = cur.next)
        {
            size++;
        }
        return size;
    }

    public void add(T value)
    {
        Node newNode = new Node(null, value);

        if(isEmpty())
        {
            this.head = newNode;
            this.tail = newNode;
        }
        else
        {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public Node<T> findPre(T value)
    {
        if(this.isEmpty())
        {
            return null;
        }
        if(this.head.value.equals(value))
        {
            return null;
        }
        for(Node<T> pre = this.head, cur = this.head.next; cur != null; pre = cur, cur = cur.next)
        {
            if(cur.value.equals(value))
            {
                return pre;
            }
        }
        return null;
    }

    public void remove(T value)
    {
        if(this.isEmpty())
        {
            return;
        }
        if(this.head.value.equals(value))
        {
            if(this.head == this.tail)
            {
                this.head = null;
                this.tail = null;
            }
            else
            {
                this.head = this.head.next;
            }
        }
        else
        {
            Node<T> pre = this.findPre(value);
            Node<T> cur = pre.next;
            pre.next = cur.next;
            if(cur == this.tail)
            {
                this.tail = pre;
            }
        }
    }

    public void printAll()
    {
        if(this.isEmpty())
        {
            return;
        }
        for(Node<T> cur = this.head; cur != null; cur = cur.next)
        {
            System.out.println(cur.getValue());
        }
    }

    public static void main(String[] args)
    {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        System.out.println(linkedList.size());
        System.out.println(linkedList.isEmpty());
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.printAll();
        linkedList.remove(1);
        linkedList.printAll();
        System.out.println(linkedList.size());
    }
}
