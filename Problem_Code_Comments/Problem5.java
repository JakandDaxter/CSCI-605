public class Problem5 {
	public static int min(int x, int y) {
		if (x < y) {
			return x;
		}
	}

	public static void main(String[] args) {
		int i = min(10, 20);
	}
}
// missing return statement in the public static int min, missplacement of return statement