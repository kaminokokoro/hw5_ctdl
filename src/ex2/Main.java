package ex2;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<String> root = tree.addRoot("*");
        tree.addLeft(root, "+");
        tree.addRight(root, "-");
        tree.addLeft(tree.findNode(root, "+"), "/");
        tree.addRight(tree.findNode(root, "+"), "3");
        tree.addLeft(tree.findNode(root, "-"), "7");
        tree.addRight(tree.findNode(root, "-"), "4");
        tree.addLeft(tree.findNode(root, "/"), "6");
        tree.addRight(tree.findNode(root, "/"), "2");
        System.out.println("Linked Tree");
        ExpressionTree<String> expressionTree = new ExpressionTree<>();
        expressionTree.inorderPrint(root);
        System.out.println();
        expressionTree.preorderPrint(root);
        System.out.println();
        expressionTree.postorderPrint(root);
        System.out.println();
        expressionTree.inorderPrint(root);
        System.out.println("= " + expressionTree.caculateExpressionTree(root));

    }


}
