package ex2;


public class ExpressionTree<E> extends LinkedBinaryTree<E> {
    public void preorderPrint(Node<E> p) {
        //pre-order traversal of tree with root p
        if (p != null) {
            System.out.print(p.getElement());
            if (p.getLeft() != null) preorderPrint(p.getLeft());
            if (p.getRight() != null) preorderPrint(p.getRight());
        }

    }

    public void postorderPrint(Node<E> p) {
        //post-order traversal of tree with root p
        if (p != null) {
            if (p.getLeft() != null) postorderPrint(p.getLeft());
            if (p.getRight() != null) postorderPrint(p.getRight());
            System.out.print(p.getElement());
        }
    }

    public void inorderPrint(Node<E> p) {
        //in-order traversal of tree with root p
        if (p != null) {
            if ((p.getElement().equals("+") || p.getElement().equals("-")) &&
                    (p.getLeft().getElement().equals("*") || p.getLeft().getElement().equals("/"))) {
                System.out.print("(");
            }
            if (p.getLeft() != null) inorderPrint(p.getLeft());
            System.out.print(p.getElement());
            if ((p.getElement().equals("*") || p.getElement().equals("/")) &&
                    (p.getRight().getElement().equals("+") || p.getRight().getElement().equals("-"))) {
                System.out.print("(");
            }
            if (p.getRight() != null) inorderPrint(p.getRight());
            if ((p.getElement().equals("+") || p.getElement().equals("-")) &&
                    (p.getLeft().getElement().equals("*") || p.getLeft().getElement().equals("/"))) {
                System.out.print(")");
            }
            if ((p.getElement().equals("*") || p.getElement().equals("/")) &&
                    (p.getRight().getElement().equals("+") || p.getRight().getElement().equals("-"))) {
                System.out.print(")");
            }
        }
    }

    public double caculateExpressionTree(Node<E> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return Double.parseDouble(root.getElement().toString());
        }
        double left = caculateExpressionTree(root.getLeft());
        double right = caculateExpressionTree(root.getRight());
        double result = 0;
        switch (root.getElement().toString()) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "/":
                result = left / right;
                break;
        }
        return result;
    }
}
