package pengliu.cf.questions;

/**
 * Created by peng on 8/20/16.
 */

//双向链表的翻转
public class RevertLinkedList<T>
{
    private Node<T> head;

    private static class Node<T>
    {
        T value;
        Node<T> next;
        Node<T> pre;
    }

    public Node<T> revert()
    {
        if(this.head == null)
        {
            return null;
        }

        Node<T> cur = head;
        while(cur.next != null)
        {
            Node<T> temp = cur.next;
            cur.next = cur.pre;
            cur.pre = temp;
        }

        head = cur;
        cur.next = cur.pre;
        cur.pre = null;

        return head;
    }
}
