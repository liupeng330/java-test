package pengliu.cf;

import java.util.LinkedList;

/**
 * Created by peng on 7/27/16.
 */
public class MyQueue<T>
{
    private LinkedList<T> innerList = new LinkedList<>();

    public void enQueue(T element)
    {
        this.innerList.addLast(element);
    }

    public T deQueue()
    {
        return this.innerList.removeFirst();
    }

    public int size()
    {
        return this.innerList.size();
    }

    public boolean isEmpty()
    {
        return this.innerList.isEmpty();
    }

    public static void main(String[] args)
    {
        MyQueue<String> queue = new MyQueue<>();
        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        queue.enQueue("d");

        while(!queue.isEmpty())
        {
            System.out.println(queue.deQueue());
        }
    }
}
