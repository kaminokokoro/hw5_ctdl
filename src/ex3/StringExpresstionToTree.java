package ex3;

import java.util.Stack;

public class StringExpresstionToTree {
    private String[] expression;
    private LinkedBinaryTree<String> tree;
    private LinkedBinaryTree.Node<String> root;

    public StringExpresstionToTree(String[] expression) {
        this.expression = expression;
    }


    public void infixExpressionToPostfixExpression() {
        String[] postfixExpression = new String[expression.length];
        int postfixExpressionIndex = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("(")) {
                stack.push(expression[i]);
            } else if (expression[i].equals(")")) {
                while (!stack.peek().equals("(")) {
                    postfixExpression[postfixExpressionIndex] = stack.pop();
                    postfixExpressionIndex++;
                }
                stack.pop();
            } else if (expression[i].equals("+") || expression[i].equals("-") || expression[i].equals("*") || expression[i].equals("/")) {
                while (!stack.isEmpty() && !stack.peek().equals("(") && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                    postfixExpression[postfixExpressionIndex] = stack.pop();
                    postfixExpressionIndex++;
                }
                stack.push(expression[i]);
            } else {
                postfixExpression[postfixExpressionIndex] = expression[i];
                postfixExpressionIndex++;
            }
        }
        while (!stack.isEmpty()) {
            postfixExpression[postfixExpressionIndex] = stack.pop();
            postfixExpressionIndex++;
        }
        expression = postfixExpression;

        for (int i = 0; i < expression.length; i++) {
            System.out.print(expression[i]);
        }
    }

    public void postfixExpressionToTreeExpression() {
        tree = new LinkedBinaryTree<>();
        Stack<LinkedBinaryTree.Node<String>> stack = new Stack<>();
        for (int i = 0; i < expression.length; i++) {
            if (expression[i] == null || expression[i].equals("")) {
                continue;
            }
            if (expression[i].equals("+") || expression[i].equals("-") || expression[i].equals("*") || expression[i].equals("/")) {
                LinkedBinaryTree.Node<String> node = tree.addRoot(expression[i]);
                LinkedBinaryTree.Node<String> right = stack.pop();
                LinkedBinaryTree.Node<String> left = stack.pop();
                tree.attach(node, left, right);
                stack.push(node);

            } else {
                stack.push(tree.addRoot(expression[i]));
            }
        }
        root = stack.pop();


    }

    public LinkedBinaryTree<String> getTree() {
        return tree;
    }

    public LinkedBinaryTree.Node<String> getRoot() {
        return tree.root;
    }
}
