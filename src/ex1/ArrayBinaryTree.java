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
        int countSize = 0;
       while(countSize<n){
            if(array[i]!=null){
                countSize++;
            }

            if(array[i]==p){
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public E parent(E p) {
        return array[(indexOf(p)-1)/2];
    }

    @Override
    public E left(E p) {
        return array[(indexOf(p)*2)+1];
    }

    @Override
    public E right(E p) {
        return array[(indexOf(p)*2)+2];
    }

    @Override
    public E sibling(E p) {
        return array[indexOf(p)+1];
    }

//    public int depth(E p){
//        int index = indexOf(p);
//        int depth = 1;
//        while (Math.pow(2,depth)+2>index){
//            depth++;
//        }
//        return depth;
//    }

//    public int height(E p){
//        int index = indexOf(p);
//        int height = 1;
//        int countSize = 0;
//        int i=0;
//        while(countSize==index) {
//            if (array[i] != null) {
//                countSize++;
//            }
//            i++;
//        }
//        while (Math.pow(2,height)+2>countSize){
//            height++;
//        }
//        return height;
//    }
        public int heightOfTree(){
            int indexMax=0;
            int countSize = 0;
            while(countSize<n){
                if(array[indexMax]!=null){
                    countSize++;
                }
                indexMax++;
            }
            indexMax--;
            //System.out.println(indexMax);
            int height = 1;
            while (Math.pow(2,height)-2<indexMax){
                height++;
            }
            return height;
        }

        public E get(int index){
            return array[index];
        }

    //access methods
}
