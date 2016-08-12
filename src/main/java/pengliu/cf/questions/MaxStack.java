package pengliu.cf.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by peng on 8/12/16.
 */
public class MaxStack<T extends Comparable<T>>
{
    private int topIndex = -1;
    private LinkedList<T> innerList = new LinkedList<>();
    private LinkedList<Integer> maxIndexStack = new LinkedList<>();

    public boolean isEmpty()
    {
        return this.innerList.isEmpty();
    }

    public void push(T value)
    {
        topIndex++;
        if(this.maxIndexStack.peek() == null)
        {
            this.maxIndexStack.addLast(topIndex);
        }
        else if(this.innerList.get(this.maxIndexStack.peek()).compareTo(value) < 0)
        {
            this.maxIndexStack.addLast(topIndex);
        }
        this.innerList.addLast(value);
    }

    public T peek()
    {
        if(!isEmpty())
        {
            return innerList.getLast();
        }
        return null;
    }

    public T pop()
    {
        if(!isEmpty())
        {
            if(topIndex == this.maxIndexStack.getLast())
            {
                this.maxIndexStack.removeLast();
            }
            topIndex--;
            return this.innerList.removeLast();
        }
        return null;
    }

    public T getMax()
    {
        if(!isEmpty())
        {
            return this.innerList.get(this.maxIndexStack.getLast());
        }
        return null;
    }

    public static void main(String[] args)
    {
        MaxStack<Integer> maxStack = new MaxStack<>();
        maxStack.push(5);
        maxStack.push(0);
        maxStack.push(1);
        maxStack.push(3);

        System.out.println(String.format("Current max value is %d", maxStack.getMax()));
        System.out.println(String.format("Pop value: %d", maxStack.pop()));
        System.out.println(String.format("Current max value is %d", maxStack.getMax()));
        System.out.println(String.format("Pop value: %d", maxStack.pop()));
        System.out.println(String.format("Current max value is %d", maxStack.getMax()));
        System.out.println(String.format("Pop value: %d", maxStack.pop()));
        System.out.println(String.format("Current max value is %d", maxStack.getMax()));
        System.out.println(String.format("Pop value: %d", maxStack.pop()));
        System.out.println(String.format("Current max value is %d", maxStack.getMax()));
    }
}
