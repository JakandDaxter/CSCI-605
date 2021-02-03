package poly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Class - This class is the Main class from which "PolyDerive", "PolyEval", and "PolyString" and invoked from to give the
output from user input.
 @author Aliana Tejeda
 @version 02/02/2021
 */
public class PolyMain {
	
	public static void main(String[] args) {
		/*
			string builder to display the derivative without brackets
		 */
		StringBuilder out = new StringBuilder();
		
		/* init. the scanner to read the number*/
		System.out.print("java PolyMain ");
		Scanner scanner = new Scanner(System.in);

		
		String[] str;
		
		List<Integer> list = new ArrayList<Integer>();
		
		str = scanner.nextLine().split(" ");
		
		for(int i = 0 ;i < str.length; i++){
			if(str[i]!=""){
				list.add(Integer.parseInt(str[i]));
			}
		}
		
		/* Displaying the polynomial string */
		System.out.println("f(x) = " + PolyString.getString(list));
		
		System.out.print("Enter x: ");
		double x = scanner.nextDouble();
		/* Displaying the Result of the Polynomial with a given x value */
		System.out.println("f(" + x +  ") = " + PolyEval.evaluate(list,x));
		
		/* Displaying the polynomial Derivative */
		list = PolyDerive.computeDerivative(list);
		if(list.size() == 0){
			System.out.println("f'(x) = " + 0);
		}else {
			for(int i = list.size()-1; i > 0;i--)
			{
				if(list.get(i)==0) continue;
				if(list.get(i)==-1){out.append("-");}
				else if(list.get(i)!=1){out.append(list.get(i));}
				if(i == 1){
					out.append("x");
					out.append(" + ");}
				else{
					out.append("x^");
					out.append(i);
					out.append(" + ");}
			}
			
			out.append(list.get(0));
			}
			System.out.println("f'(x) = " + out.toString());
		}
	}

