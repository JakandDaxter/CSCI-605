package hw3;
/**
* A test unit for the SubExpression class.
*
* @author Aliana Tejeda & Bem Lordaah
*/
import java.util.*;

public class Interp {

    /*
        method to take string input and break it apart
        by the spaces within the string input and
        parses the input into a linked list
     */
    public Expression parseExpression(String str){
        //checking if input is lengh 0 or null
        if(str == null || str.length()==0){
            return null;
        }
        // assuming input is correct
        // data is seperated by spaces
        String[] tokenArray = str.split(" ");
        // create linked list for the parsed data coming form the stirng input
        LinkedList<String> tokenList = new LinkedList<>();
        // for every string within the stringArray
        for(String tokenStr : tokenArray){
            //delete the white space
            if(tokenStr.trim().length()>0){
                //add the bare data to the linked list
                tokenList.addLast(tokenStr);
            }
        }
        //return the list of parsed data
        return parseTree(tokenList);
    }

    /*
        method that creates the tree using linked list
     */
    public Expression parseTree(LinkedList<String> list){
        //base case: checking if the first element is an integer
        if(isNumber(list.peekFirst())){

            return new IntExp(getIntValue(list.pollFirst()));
        }

        //gets the first thing in the list that is not an intenger
        // pollFirst pops the first element out
        String currToken = list.pollFirst();

        //looking for left and right elements
        Expression leftExp = parseTree(list);

        Expression rightExp = parseTree(list);

        return getExpression(currToken,leftExp,rightExp);
    }

    public Expression getExpression(String operator, Expression left, Expression right) {

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

    //checking if current node is a number
    public boolean isNumber(String operand) {
        try{
            Integer.parseInt(operand);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }

    public int getIntValue(String value){
        return Integer.parseInt(value);
    }

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


    public static void main(String[] args) {

        new Interp().runInterpreter();

    }
}
