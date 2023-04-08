package ex2;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<E> {
    protected static class Node<E> {
        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child
        private Node<E> right; // a reference to the right child
        // Constructs a node with the given element and neighbors. ∗/
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
// Sinh viên hoàn thiện phương thức
            this.element = e;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }
    }
    protected Node<E> root = null; // root of the tree
    private int size = 0; // number of nodes in the tree
    public LinkedBinaryTree() { // constructs an empty binary tree
    }

    //update methods
    public Node<E> addRoot(E element) {
        Node node = new Node(element, null, null, null);
        root= node;
        size++;
        return node;

// Add element to root of an empty tree
    }
    public Node<E> addLeft(Node p, E element) {
// Add element to left child node of p if empty
        Node node = new Node(element, p, null, null);
        p.left = node;
        size++;
        return node;
    }
    public Node<E> addRight(Node p, E element) {
// Add element to right child node of p if empty
        Node node = new Node(element, p, null, null);
        p.right = node;
        size++;
        return node;
    }
    public void set(Node p, E element) {
// set element to node p
        p.element = element;
    }

    @Override
    public E root() {
        return root.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public Node<E> findNode(Node node,E element){
        if(node==element){
            return node;
        }else {
            if(node.left!=null){
                findNode(node.left,element);
            }
            if(node.right!=null){
                findNode(node.right,element);
            }
        }
        return null;
    }

    @Override
    public int numChildren(E p) {
        int result = 0;
        Node node = findNode(root,p);
        if(node.left!=null)result++;
        if(node.right!=null)result++;
        return result;
    }

    @Override
    public E parent(E p) {

        return findNode(root,p).parent.element;
    }

    @Override
    public E left(E p) {
        return findNode(root,p).left.element;
    }

    @Override
    public E right(E p) {
        return findNode(root,p).right.element;
    }

    @Override
    public E sibling(E p) {
        return findNode(root,p).parent.left.element==p?findNode(root,p).parent.right.element:findNode(root,p).parent.left.element;
    }
}
