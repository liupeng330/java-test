package pengliu.cf.test2;

import java.util.LinkedList;

/**
 * Created by peng on 7/10/16.
 */
public class LinkedStack<T>
{
    private static class Node<U>
    {
        private U value;
        private Node<U> next;

        public Node(U value, Node<U> next)
        {
            this.setValue(value);
            this.setNext(next);
        }

        public U getValue() {
            return value;
        }

        public void setValue(U value) {
            this.value = value;
        }

        public Node<U> getNext() {
            return next;
        }

        public void setNext(Node<U> next) {
            this.next = next;
        }
    }

    private Node<T> top;

    public boolean isEmpty()
    {
        return this.top == null;
    }

    public void push(T value)
    {
        Node<T> newNode = new Node(value, this.top);
        this.top = newNode;
    }

    public T pop()
    {
        if (top  == null)
        {
            return null;
        }
        T returnValue = this.top.getValue();

        this.top = this.top.getNext();
        return returnValue;
    }

    public static void main(String[] args)
    {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        System.out.println(linkedStack.isEmpty());
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);

        while(!linkedStack.isEmpty())
        {
            System.out.println(linkedStack.pop());
        }
    }
}
