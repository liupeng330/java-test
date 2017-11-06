package pengliu.cf.search;

/**
 * Created by peng on 11/5/17.
 */
//二叉查找树
public class BinarySearchTree <Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value value;
        //记录以该节点为根的子树中节点的总个数
        private int N;

        private Node left;
        private Node right;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    //当前二叉树的根节点
    private Node root;

    public int size() {
        return size(root);
    }

    //次方法是为了后面的rank和selet方法的计算所使用
    private int size(Node node) {
        if(node == null) {
            return 0;
        }
        else {
            return node.N;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if(node == null)  throw new RuntimeException("In the BST, Cannot find node with key " + key);
        int cmp = key.compareTo(node.key);
        if(cmp == 0) { return node.value; }
        if(cmp < 0) { return get(node.left, key); }
        else { return get(node.right, key); }
    }

    //查找key, 找到就更新其节点的value；找不到就新插入一个node
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        //递归到空节点，说明要插入一个新的node了
        //将新的节点返回给上层方法，在退递归的时候置其父节点的左子树或右子树
        if(node == null) { return new Node(key, value, 1); }

        int cmp = key.compareTo(node.key);
        if(cmp < 0) { node.left = put(node.left, key, value); }
        if(cmp > 0) { node.right = put(node.right, key, value); }
        //找到相同key的节点，就更新其value值
        else { node.value = value; }

        //当插入新的节点的时候才需要更新查询路径上N的值，
        //这里的代码简化了次判断，无论是否是插入了新的节点，
        //还是更新了已有节点的值，都重新计算查找路径上所有node的N值
        node.N = size(node.left) + size(node.right) + 1;

        //每次都返回当前节点给上层方法，退递归时重置查找路径上父节点指向子节点的引用
        return node;
    }

    public Node min() {
        if(root == null) return null;
        return min(root);
    }

    private Node min(Node node) {
        if(node.left == null) { return node; }
        else { return min(node.left); }
    }

    public Node max() {
        if(root == null) return null;
        return max(root);
    }

    private Node max(Node node) {
        if(node.right == null) { return node; }
        else { return max(node.right); }
    }

    //找到向下取整的节点，即二叉树中小于等于key的最大节点
    public Node floor(Key key) {
        return floor(root, key);
    }

    private Node floor(Node node, Key key) {
        if(node == null) return null;

        int cmp = key.compareTo(node.key);
        //找到与key相等的节点，直接返回即可
        if(cmp == 0) {return node;}
        //小于，则继续在左子树中查找
        if(cmp < 0) { return floor(node.left, key); }
        else {
            //大于，先在当前节点的右子树中查找
            Node result = floor(node.right, key);
            //在右子树中能找到，则返回其结果
            if(result!=null) {return result;}
            //大于，且在右子树中找不到，那么当前节点就是最接近key的节点了，返回即可
            else { return node; }
        }
    }

    //找到向上取整的节点，即二叉树中大于等于key的最小节点
    public Node ceiling(Key key) {
        return ceiling(root, key);
    }

    private Node ceiling(Node node, Key key) {
        if(node == null) return null;

        int cmp = key.compareTo(node.key);
        if(cmp == 0) {return node;}
        if(cmp > 0) { return ceiling(node.right, key); }
        else {
            Node result = ceiling(node.left, key);
            if(result!=null) {return result;}
            else { return node; }
        }
    }

    //返回排名为k的节点
    //即要找一个节点，它前面有k个节点，它是第k+1个节点
    //即要找树中有k个节点小于它的节点
    public Node select(int k) {
        return select(root, k);
    }

    private Node select(Node node, int k) {
        if(node == null) return null;

        //当前节点的排名主要由其左子树包含多少个节点决定
        int t = size(node.left);

        //小于node的排名，则在其左子树中继续递归查找
        if(k < t) { return select(node.left, k); }
        //大于node的排名，则在其右子树中继续递归查找，但是相对于右子树的k要相应的减少
        else if(k > t) { return select(node.right, k-t-1); }
        else { return node; }
    }

    //rank就是算此节点前有多少个节点存在
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if(node == null) return 0;
        int cmp = key.compareTo(node.key);
        if(cmp < 0) { return rank(node.left, key); }
        if(cmp > 0) { return rank(node.right, key) + size(node.left) + 1; }
        else { return size(node.left); }
    }

    //删除树中最小的节点
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        //找到了最小节点，则返回其右节点给上层递归调用，在退递归的时候赋给其父节点
        //当前节点回变成无人引用的节点，会被垃圾回收掉
        if(node.left == null) {
            return node.right;
        }
        else {
            //退递归时重置左节点
            node.left = deleteMin(node.left);
            return node;
        }
    }

    //删除树中最大的节点
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if(node.right == null) {
            return node.left;
        }
        else {
            node.right = deleteMax(node.right);
            return node;
        }
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if(node == null) return null;

        int cmp = key.compareTo(node.key);
        //要删除的节点在左子树中，则继续搜索左子树
        if(cmp < 0) { node.left = delete(node.left, key); }
        //要删除的节点在右子树中，则继续搜索右子树
        else if(cmp > 0) {node.right = delete(node.right, key); }
        //找到了要删除的节点
        else {
            //如果找到的节点没有左子树，或者没有右子树，那么直接返回另一边的节点引用给上层递归
            //在退递归的时候，会将返回的节点赋给上层父节点
            if(node.left == null) { return node.right; }
            if(node.right == null) { return node.left; }

            //处理被删除的节点其左右节点都有子树的情况
            //1. 先找到其后继节点
            Node t = min(node.right);
            //2. 将其后继节点从右子树中删除(不是真的删除，只是从右子树中去除引用)，并将删除后形成的新的右子树赋给这个后继节点的右子树
            t.right = deleteMin(node.right);
            //3. 将其后继节点的左子树置为要被删除节点的左子树
            t.left = node.left;
            node = t;
        }

        //重新计算寻找被删除节点路径上所有节点的N
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    //中序遍历,即按顺序打印二叉树
    public void print() {
        print(root);
    }

    private void print(Node node) {
        if(node == null) return;
        print(node.left);
        System.out.println(node.key + "--" + node.value);
        print(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(10, "a");
        bst.put(9, "b");
        bst.put(8, "c");
        bst.put(1, "d");
        bst.put(7, "e");
        bst.put(6, "u");

        bst.print();

        System.out.println(bst.size());
        System.out.println(bst.max().key);
        System.out.println(bst.min().key);
        bst.put(13, "123");
        bst.print();

        System.out.println(bst.floor(5).key);
        System.out.println(bst.ceiling(5).key);
        System.out.println(bst.rank(7));
        bst.delete(10);
        System.out.println(bst.max().key);
        bst.deleteMax();
        System.out.println(bst.max().key);
    }
}
