package pengliu.cf;

import java.util.Comparator;
import java.util.Queue;

/**
 * Created by peng on 7/29/16.
 */
public class Tree<T extends Comparable<T>> // 使得树中的节点支持比较接口
{
    public Tree(T value)
    {
        this.root = new TreeNode<>(value);
    }

    private TreeNode<T> root;

    public TreeNode<T> getRoot()
    {
        return root;
    }

    public static class TreeNode<T>
    {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T value)
        {
            this.value = value;
        }
    }

    // T(N) = O(N), N为树中节点的个数
    public void removeAllNodes(TreeNode<T> root)
    {
        if(root == null)
        {
            return;
        }
        removeAllNodes(root.left);
        removeAllNodes(root.right);
        root = null;
    }

    // T(N) = O(log N), 时间复杂度为树的深度
    public TreeNode<T> findByValue(TreeNode<T> root, T value)
    {
        if(root == null) return null;

        if(root.value.compareTo(value) < 0)
        {
            return findByValue(root.left, value);
        }
        else if(root.value.compareTo(value) > 0)
        {
            return findByValue(root.right, value);
        }
        return root;
    }

    // T(N) = O(log N), 时间复杂度为树的深度
    public T findMinValue(TreeNode<T> root)
    {
        if(root == null) return null;

        if(root.left == null)
        {
            return root.value;
        }

        return findMinValue(root.left);
    }

    // T(N) = O(log N), 时间复杂度为树的深度
    public T findMaxValue(TreeNode<T> root)
    {
        if(root == null) return null;

        while(root.right != null)
        {
            root = root.right;
        }

        return root.value;
    }

    public void insertNode(T value)
    {
        this.root = insertNode(root, value);
    }

    private TreeNode<T> insertNode(TreeNode<T> root, T value)
    {
        //找到的要插入的点, 创建新节点, 并返回引用
        if(root == null)
        {
            return new TreeNode<T>(value);
        }
        if(root.value.compareTo(value) > 0)
        {
            root.left = insertNode(root.left, value);
        }
        else if(root.value.compareTo(value) < 0)
        {
            root.right = insertNode(root.right, value);
        }

        // 无论插入的value大于, 小于或者等于root的value时, 都要返回root的引用给上层递归
        return root;
    }

    // 层序遍历二叉树
    public void printByLevel()
    {
        MyQueue<TreeNode<T>> queue = new MyQueue<>();
        if(this.root == null)
        {
            return;
        }
        queue.enQueue(this.root);
        while(!queue.isEmpty())
        {
            TreeNode<T> firstNode = queue.deQueue();
            System.out.println(firstNode.value);
            if(firstNode.left != null)
            {
                queue.enQueue(firstNode.left);
            }
            if(firstNode.right != null)
            {
                queue.enQueue(firstNode.right);
            }
        }
    }

    public static void main(String[] args)
    {
        Tree<Integer> tree = new Tree<>(8);
        tree.insertNode(7);
        tree.insertNode(3);
    }
}
