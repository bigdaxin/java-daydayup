package list;

public class TreeNode<E> {
    public E e;
    public TreeNode<E> lift;
    public TreeNode<E> right;

    public TreeNode(E e){
        this.e = e;
    }

    public void each(TreeNode<String> treeNode){
        if (treeNode == null) return;
//        System.out.println(treeNode.e);//前序遍历

        each(treeNode.lift);
//        System.out.println(treeNode.e);//中序遍历

        each(treeNode.right);

        System.out.println(treeNode.e);//后序遍历

    }
}
