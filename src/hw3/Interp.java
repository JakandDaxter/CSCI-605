package hw3;

import java.util.*;

public class Interp {

    private Expression parseExpression(String str){
        if(str == null || str.length()==0){
            return null;
        }

        String[] tokenArray = str.split(" ");

        LinkedList<String> tokenList = new LinkedList<>();

        for(String tokenStr : tokenArray){
            if(tokenStr.trim().length()>0){
                tokenList.addLast(tokenStr);
            }
        }

        return parseTree(tokenList);
    }

    private Expression parseTree(LinkedList<String> list){

        if(isNumber(list.get(0))){
            return new IntExp(getIntValue(list.pollFirst()));
        }

        String currToken = list.pollFirst();

        Expression leftExp = parseTree(list);

        Expression rightExp = parseTree(list);

        return getExpression(currToken,leftExp,rightExp);
    }

    private Expression getExpression(String operator, Expression left, Expression right) {

        switch (operator){
            case "+" :
                return new AddExp(left,right);

            case "-" :
                return new SubExp(left,right);

            case "/" :
                return new DiviExp(left, right);

            case "%" :
                return new ModExp(left, right);

            case "*" :
                return new MulExp(left, right);

            default:
                return null;
        }
    }

    private boolean isNumber(String operand) {
        try{
            Integer.parseInt(operand);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }

    private int getIntValue(String value){
        return Integer.parseInt(value);
    }

    private void runInterpreter(){

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


    public static void main(String[] args) {

        new Interp().runInterpreter();

    }
}
