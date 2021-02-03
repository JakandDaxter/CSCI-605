public class Problem10 {
	public static void main(String[] args) {
		String s1 = "Hello world";
		System.out.println(s1.substring(6,12));
	}
}
//there are only 10 substrings which Hello World including the space.
// The bounds on the right are out of bounds. Best to get the size then try again with correct bounds