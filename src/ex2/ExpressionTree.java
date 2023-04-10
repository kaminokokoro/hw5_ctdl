package ex2;



public class ExpressionTree<E> extends LinkedBinaryTree<E> {
    public void preorderPrint(Node<E> p) {
        //pre-order traversal of tree with root p
        if(p!=null){
            System.out.print(p.getElement());
            if(p.getLeft()!=null)preorderPrint(p.getLeft());
            if(p.getRight()!=null)preorderPrint(p.getRight());
        }

    }
//    public void preorder(LinkedBinaryTree<Integer> tree, LinkedBinaryTree.Node<Integer> n){
//        if(n!=null){
//            if(n.getLeft()!=null)preorder(tree,n.getLeft());
//            System.out.println(n.getElement());
//            if(n.getRight()!=null)preorder(tree,n.getRight());
//
//        }
//    }

    public void postorderPrint(Node<E> p) {
        //post-order traversal of tree with root p
        if(p!=null){
            if(p.getLeft()!=null)postorderPrint(p.getLeft());
            if(p.getRight()!=null)postorderPrint(p.getRight());
            System.out.print(p.getElement());
        }
    }

    public void inorderPrint(Node<E> p) {
        //in-order traversal of tree with root p
        if(p!=null){
            if(p.getLeft()!=null)inorderPrint(p.getLeft());
            System.out.print(p.getElement());
            if(p.getRight()!=null)inorderPrint(p.getRight());
        }
    }
}
