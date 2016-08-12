package pengliu.cf.questions;

import pengliu.cf.Tree;

/**
 * Created by peng on 16-8-10.
 */
public class SameTree
{
    /*
    Given two binary trees, write a function to check if they are equal or not.
    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     */
    public static boolean isSameTree(TreeNode p, TreeNode q)
    {
        if(p == null && q == null)
        {
            return true;
        }
        else if(p == null || q == null)
        {
            return false;
        }

        return p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class TreeNode
{
    TreeNode left;
    TreeNode right;
    int value;
}
