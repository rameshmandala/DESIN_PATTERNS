package com.mylearning.designpatterns.A0023_Interpreter;

import java.util.HashMap;
import java.util.Stack;

interface Expression {
    public int interpret(HashMap<String,Integer> variables);
}

class Number implements Expression {
    private final int number;
    public Number(int number)       { this.number = number; }
    public int interpret(HashMap<String,Integer> variables)  { return number; }
}

class Plus implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public Plus(Expression left, Expression right) {
        leftOperand = left;
        rightOperand = right;
    }

    public int interpret(HashMap<String,Integer> variables)  {
        return leftOperand.interpret(variables) + rightOperand.interpret(variables);
    }
}

class Minus implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public Minus(Expression left, Expression right) {
        leftOperand = left;
        rightOperand = right;
    }

    public int interpret(HashMap<String,Integer> variables)  {
        return leftOperand.interpret(variables) - rightOperand.interpret(variables);
    }
}

class Variable implements Expression {
    private final String name;
    public Variable(String name)       { this.name = name; }
    public int interpret(HashMap<String,Integer> variables)  {
        return variables.get(name);
    }
}


class Evaluator {
    private final Expression syntaxTree;

    public Evaluator(String expression) {
        final Stack<Expression> expressionStack = new Stack<Expression>();
        for (final String token : expression.split(" ")) {
            if  (token.equals("+")) {
                final Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
                expressionStack.push( subExpression );
            }
            else if (token.equals("-")) {
                final Expression subExpression = new Minus(expressionStack.pop(), expressionStack.pop());
                expressionStack.push( subExpression );
            }
            else
            {
                expressionStack.push( new Variable(token) );
            }
        }
        syntaxTree = expressionStack.pop();
    }

    public int evaluate(HashMap<String,Integer> context) {
        return syntaxTree.interpret(context);
    }
}


public class InterpreterDemo {
    public static void main(String[] args) {
        final String expression = "w x z - +";
        final Evaluator sentence = new Evaluator(expression);
        final HashMap<String,Integer> variables = new HashMap<String,Integer>();
        variables.put("w", 5);
        variables.put("x", 10);
        variables.put("z", 42);
        final int result = sentence.evaluate(variables);
        System.out.println(result);
    }
}
