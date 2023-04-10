package ex3;

public class Main {
    public static void main(String[] args) {
        String[] expression = {"(","6", "/", "2","+","3",")", "*", "(", "7", "-", "4",")"};
        StringExpresstionToTree stringExpresstionToTree = new StringExpresstionToTree(expression);
        ExpressionTree<String> expressionTree = new ExpressionTree<>();
        stringExpresstionToTree.infixExpressionToPostfixExpression();
        stringExpresstionToTree.postfixExpressionToTreeExpression();
        System.out.println();
        expressionTree.preorderPrint(stringExpresstionToTree.getRoot());
        System.out.println();
        expressionTree.inorderPrint(stringExpresstionToTree.getRoot());
        System.out.println();
        expressionTree.postorderPrint(stringExpresstionToTree.getRoot());

    }
}
