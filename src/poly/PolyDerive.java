package poly;

import java.util.ArrayList;
import java.util.List;

/*Class - This class computes the derivative of the polynomial given in the main class.
 @author Aliana Tejeda
 @version 02/02/2021
 */
public class PolyDerive {
	
	public static List<Integer> computeDerivative(List<Integer> poly)
	{
		
		List<Integer> list = new ArrayList<Integer>();
		int mover;

		for (int i = 1; i < poly.size() ; i++) {
			mover = (poly.get(i)*i);
			list.add(i-1,mover);
		}
		
		return list;
	}
}
