package tarea3.calculadoraartimetica;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShuntingYardAlgorithm {

    public static List<String> shuntingYard(List<String> tokens) {
        List<String> outputQueue = new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                // Rule 3: If the token is a number, add it to the output queue.
                outputQueue.add(token);
            } else if (isOperator(token)) {
                // Rule 4: If the token is an operator
                while (!operatorStack.isEmpty() && hasGreaterPrecedence(operatorStack.peek(), token)) {
                    // Rule 5: Pop operators from the operator stack onto the output queue with greater precedence.
                    outputQueue.add(operatorStack.pop());
                }
                // Rule 7: Push the read operator onto the operator stack.
                operatorStack.push(token);
            } else if (token.equals("(")) {
                // Rule 8: If the token is a left parenthesis (i.e., "("), then push it onto the operator stack.
                operatorStack.push(token);
            } else if (token.equals(")")) {
                // Rule 10: If the token is a right parenthesis (i.e., ")")
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    // Rule 11: Pop operators from the operator stack onto the output queue until a left parenthesis is encountered.
                    outputQueue.add(operatorStack.pop());
                }
                // Rule 12: Pop the left parenthesis from the operator stack.
                operatorStack.pop();
            }
        }

        // Rule 13: While there are operators on the operator stack, pop them onto the output queue.
        while (!operatorStack.isEmpty()) {
            outputQueue.add(operatorStack.pop());
        }

        return outputQueue;
    }

    // Helper method to check if a token is a number
    private static boolean isNumber(String token) {
        // Your implementation to check if a token is a number
        return token.matches("\\d+");
    }

    // Helper method to check if a token is an operator
    private static boolean isOperator(String token) {
        // Your implementation to check if a token is an operator
        return token.matches("[+\\-*/]");
    }

    // Helper method to compare operator precedence
    private static boolean hasGreaterPrecedence(String op1, String op2) {
        // Your implementation to compare operator precedence
        // Return true if op1 has greater precedence than op2
        // You need to define the precedence order based on your operators
        return false;
    }


}
