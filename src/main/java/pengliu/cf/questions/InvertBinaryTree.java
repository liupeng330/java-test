package pengliu.cf.questions;

/**
 * Created by peng on 16-8-10.
 */
public class InvertBinaryTree
{
    public TreeNode invertTree(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

