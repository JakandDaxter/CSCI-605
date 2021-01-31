package primality;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;


public class SieveOfEratosthenes {
	//method to find prime numbers
	public static int[] makeSieve(int upperBound){
		/* Creating array with upper bound, plus 1 to create all buckets user intended*/
		int[] sieve = new int[upperBound+1];
		
		//array is set to all prime
		Arrays.fill(sieve,0);
		/*
		check buckets up until the square root of the upper bound
		since sqrd(sqrt(upperbound)) is <=upperbound, any number
		after that will exceede the limit since the square root
		of the upper bound is the cloest you can get to the
		perfect square of the upper bound
		 */
		for(int i = 2; i <= Math.sqrt(upperBound); i++){
			/*
			starting at i, for i+i is not prime, then
			j = i+i, where j is then j = j+i for every
			multiple of i, which is not prime
			 */
			for(int j = i+i;j <= upperBound; j=i+j){
				sieve[j]=1;
			}
		}
		
		return sieve;
	}
	
	public static void main(String[] args){
		
		/* asking for the upper bound number*/
		System.out.print("Please enter an upper bound:  ");
		
		/* init. the scanner to read the number*/
		Scanner scan = new Scanner(System.in);
		
		/* Reading the upper bound number*/
		int entry = scan.nextInt();
		
		/* creating the Sieve Of Eratosthenes */
		int[] sieve = makeSieve(entry);
		
		do{
			System.out.print("Please enter a positive number (0 to quit): ");
			
			entry = scan.nextInt();
			
			if(entry > 0){
				if(sieve[entry] == 1){
					System.out.println(entry + " is not prime.");
				} else{
					System.out.println(entry + " is prime!");
				}
			}
		}while(entry > 0);
		
		System.out.println("Goodbye!");
		System.exit(0);
	}
}
