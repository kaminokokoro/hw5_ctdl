package ex1;

public class ArrayBinaryTree<E> implements BinaryTreeInterface<E> {
    private E [] array;
    private int n = 0;
    private int defaultsize = 100;
    public ArrayBinaryTree(){
        array = (E[]) new Object[defaultsize];
    }
    //update methods
    public void setRoot(E element) {
        // Set element to root of an empty tree
        array[0]=element;
        n++;

    }
    public void setLeft(int p, E element) {
// Set left child of p
        array[p*2+1]=element;
        n++;
    }
    public void setRight(int p, E element) {
// Set right child of p
        array[p*2+2]=element;
        n++;
    }

    @Override
    public E root() {
        return  array[0];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public int numChildren(E p) {
        int result = 0;
        if(array[indexOf(p)*2+1]!=null)result++;
        if(array[indexOf(p)*2+2]!=null)result++;
        return result;
    }

    public int indexOf(Object p) {
        int i=0;
       while(i==n){
            if(array[i]!=null){
                i++;
            }
            if(array[i]==p){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object parent(Object p) {
        return array[(indexOf(p)-1)/2];
    }

    @Override
    public Object left(Object p) {
        return array[(indexOf(p)*2)+1];
    }

    @Override
    public Object right(Object p) {
        return array[(indexOf(p)*2)+2];
    }

    @Override
    public Object sibling(Object p) {
        return array[indexOf(p)+1];
    }
    //access methods
}
