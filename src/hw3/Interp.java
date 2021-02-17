package hw3;

/**
* CSCI 605 - Homework 3
* @author: Aliana Tejeda & Bem Iordaah
*/

import java.util.*;

/**
 * The Interp class is the main program class. It is responsible for reading a prefix expression
 * from the standard input, generating the corresponding parse tree, and then emitting and
 * evaluating the tree.
 *
 */

public class Interp {

    /**
     * parseExpression method receives a string input, splices it using the spaces within the string,
     * and parses the input into a linked list
     */

    public Expression parseExpression(String str){

        /**
         * check if input is length 0 or null
         * if input is correct, separate data by spaces
         * create linked list for parsed data coming from the string input
         */

        if(str == null || str.length()==0){
            return null;
        }

        String[] tokenArray = str.split(" ");
        LinkedList<String> tokenList = new LinkedList<>();

        /**
         * delete white space for every string within the stringArray and add
         * bare data to the linked list
         * @return list of parsed data
         */

        for(String tokenStr : tokenArray){
            if(tokenStr.trim().length()>0){
                tokenList.addLast(tokenStr);
            }
        }

        return parseTree(tokenList);
    }

    /**
     *  Method to create the tree using linked list
     *  Base case: check if first element is an integer before proceeding
     *  get first element in the list that is not an integer and pop it out
     *  look for left and right expressions
     *  @return IntExp
     *  @return left and right expressions
     */

    public Expression parseTree(LinkedList<String> list){

        if(isNumber(list.peekFirst())){

            return new IntExp(getIntValue(list.pollFirst()));
        }

        String currToken = list.pollFirst();

        Expression leftExp = parseTree(list);

        Expression rightExp = parseTree(list);

        return getExpression(currToken,leftExp,rightExp);
    }

    /**
     *  Method to get the expressions and determine evalution class
     */

    public Expression getExpression(String operator, Expression left, Expression right) {

        switch (operator){
            case "+" :
                return new AddExp(left,right);

            case "-" :
                return new SubExp(left,right);

            case "/" :
                return new DivExp(left, right);

            case "%" :
                return new ModExp(left, right);

            case "*" :
                return new MulExp(left, right);

            default:
                return null;
        }
    }

    /**
     *  check if current node is a number
     */

    public boolean isNumber(String operand) {
        try{
            Integer.parseInt(operand);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }

    /**
     *  Method to get integer value from string
     */

    public int getIntValue(String value){
        return Integer.parseInt(value);
    }

    /**
     *  Method to receive user input and return string expressions and evaluation results
     */

    public void runInterpreter(){

        boolean keepTakingExpression = true;

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to your Arithmetic Interpreter v1.0 :)\n\n");

        do{
            System.out.print("> ");

            String exp = scan.nextLine();

            keepTakingExpression = !exp.equalsIgnoreCase("quit");

            if(keepTakingExpression){

                Expression expression = parseExpression(exp);

                System.out.println("Emit: "+expression.emit());

                System.out.println("Evaluate: "+expression.evaluate());
            }

        }while(keepTakingExpression);

        System.out.print("Goodbye!");
    }

    /**
     *  Main method
     */

    public static void main(String[] args) {

        new Interp().runInterpreter();

    }
}
