package poly;

import java.lang.Math;
import java.util.List;

/*Class - This class evaluates the polynomial with a given x value.
 @author Aliana Tejeda
 @version 02/02/2021
 */
public class PolyEval {
	
	public static double evaluate(List<Integer> poly, double x){
		double result = 0;
		
		for(int i = 0; i < poly.size(); i++){
			if(poly.get(i)==0) continue;
			result += Math.pow(x,i)* poly.get(i);
		}
		
		return result;
	}
	
}
