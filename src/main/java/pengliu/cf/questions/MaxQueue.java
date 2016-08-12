package pengliu.cf.questions;

/**
 * Created by peng on 8/12/16.
 */
public class MaxQueue<T extends Comparable<T>>
{
    private MaxStack<T> pushStack = new MaxStack<>();
    private MaxStack<T> popStack = new MaxStack<>();

    public void enQueue(T value)
    {
        this.pushStack.push(value);
    }

    public T deQueue()
    {
        while(!this.pushStack.isEmpty())
        {
            this.popStack.push(this.pushStack.pop());
        }
        return this.popStack.pop();
    }

    public T getMax()
    {
        return max(this.pushStack.getMax(), this.popStack.getMax());
    }

    private T max(T p, T q)
    {
        if(p == null && q != null)
        {
            return q;
        }
        if(p != null && q == null)
        {
            return p;
        }
        if(p == null && q == null)
        {
            return null;
        }
        if(p.compareTo(q) < 0)
        {
            return q;
        }
        else
        {
            return p;
        }
    }

    public static void main(String[] args)
    {
        MaxQueue<Integer> maxQueue = new MaxQueue<>();
        maxQueue.enQueue(2);
        maxQueue.enQueue(3);
        maxQueue.enQueue(1);
        maxQueue.enQueue(0);
        maxQueue.enQueue(5);

        System.out.println(String.format("Max value in queue is %d", maxQueue.getMax()));
        System.out.println(String.format("Dequeue value is %d", maxQueue.deQueue()));
        System.out.println(String.format("Max value in queue is %d", maxQueue.getMax()));
        System.out.println(String.format("Dequeue value is %d", maxQueue.deQueue()));
        System.out.println(String.format("Max value in queue is %d", maxQueue.getMax()));
        System.out.println(String.format("Dequeue value is %d", maxQueue.deQueue()));
        System.out.println(String.format("Max value in queue is %d", maxQueue.getMax()));
        System.out.println(String.format("Dequeue value is %d", maxQueue.deQueue()));
        System.out.println(String.format("Max value in queue is %d", maxQueue.getMax()));
        System.out.println(String.format("Dequeue value is %d", maxQueue.deQueue()));
        System.out.println(String.format("Max value in queue is %d", maxQueue.getMax()));
        System.out.println(String.format("Dequeue value is %d", maxQueue.deQueue()));
    }
}
