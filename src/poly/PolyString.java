package poly;
/*Class - This class implements the transformation of a list of integers into a string by using the string builder class.
Then adding the necessary polynomial attributes to the respective index.
 @author Aliana Tejeda
 @version 02/02/2021
 */
import java.util.List;

public class PolyString {
	
	public static String getString(List<Integer> poly)
	{
		StringBuilder str = new StringBuilder();
		
		for (int i = poly.size()-1; i > 0; i--) {
			if(poly.get(i)==0) continue;
			
			if(poly.get(i)==-1){
				str.append("-");
			}else if(poly.get(i)!=1){
				str.append(poly.get(i));
			}
			if(i == 1){
				str.append("x");
				str.append(" + ");}else{
			str.append("x^");
			str.append(i);
			str.append(" + ");}
		}
		
		str.append(poly.get(0));
		
		return str.toString();
	}
}
