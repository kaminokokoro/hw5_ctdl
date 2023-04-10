package ex1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PrintTree {
    static FileWriter file;

    static {
        try {
            file = new FileWriter("output.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer> root = tree.addRoot(0);
        tree.addLeft(root, 1);
        tree.addRight(root, 2);
        //System.out.println(root.getLeft().getElement());
        //System.out.println(tree.findNode(root,1).getElement());
        tree.addLeft(tree.findNode(root, 1), 3);
        tree.addRight(tree.findNode(root, 1), 4);
        tree.addLeft(tree.findNode(root, 2), 5);
        tree.addRight(tree.findNode(root, 2), 6);
        tree.addLeft(tree.findNode(root, 3), 7);
        tree.addRight(tree.findNode(root, 3), 8);
        tree.addLeft(tree.findNode(root, 4), 9);
        tree.addRight(tree.findNode(root, 4), 10);
        tree.addLeft(tree.findNode(root, 5), 11);
        tree.addRight(tree.findNode(root, 5), 12);
        tree.addLeft(tree.findNode(root, 6), 13);
        tree.addRight(tree.findNode(root, 6), 14);
        ArrayBinaryTree<Integer> tree2 = new ArrayBinaryTree<>();
        tree2.setRoot(0);
        tree2.setLeft(0, 1);
        tree2.setRight(0, 2);
        tree2.setLeft(1, 3);
        tree2.setRight(1, 4);
        tree2.setLeft(2, 5);
        tree2.setRight(2, 6);
        //System.out.println(tree2.indexOf(0));

        System.out.println("Array Tree");
        file.write("Array Tree\r");
        PrintArrayTree(tree2, tree2.get(0), "");
        System.out.println("Linked Tree");
        file.write("Linked Tree\r");
        PrintLinkedTree(tree, root, "");
        file.close();
    }



    public static void PrintArrayTree(ArrayBinaryTree<Integer> tree, int n,String space) throws IOException {
        String space2 = space + "  ";
        if(tree.indexOf(n)!=-1){
            if(tree.left(n)!=null)PrintArrayTree(tree,tree.left(n),space2);
            System.out.println(space+n);
            file.write(space+n+"\r");
            if(tree.right(n)!=null)PrintArrayTree(tree,tree.right(n),space2);

        }
    }

    public static void PrintLinkedTree(LinkedBinaryTree<Integer> tree, LinkedBinaryTree.Node<Integer> n,String space) throws IOException {
        String space2 = space + "  ";
        if(n!=null){
            if(n.getLeft()!=null)PrintLinkedTree(tree,n.getLeft(),space2);
            System.out.println(space+n.getElement());
            file.write(space+n.getElement()+"\r");
            if(n.getRight()!=null)PrintLinkedTree(tree,n.getRight(),space2);

        }
    }
}
