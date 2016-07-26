package pengliu.cf;

import java.util.LinkedList;

/**
 * Created by peng on 7/25/16.
 */
public class MyStack<T>
{
    private LinkedList<T> innerList = new LinkedList<>();

    public T pop()
    {
        return this.innerList.removeLast();
    }

    public void push(T value)
    {
        this.innerList.addLast(value);
    }

    public T peek()
    {
        return this.innerList.getLast();
    }

    public boolean isEmpty()
    {
        return this.innerList.isEmpty();
    }

    public static void main(String[] args)
    {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }

    public Integer size()
    {
        return this.innerList.size();
    }
}
