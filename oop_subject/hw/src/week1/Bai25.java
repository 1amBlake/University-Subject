package week1;
import java.util.*;

class Solve25{
	
	static boolean checkPrime(int n) {
		if (n == 2) return true;
		else if (n <= 1) return false;
		else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) return false;
			}
		}
		return true;
	}
	static int sumPrime(int n) {
		int re = 0;
		for(int i = 2; i < n; i++) {
			if (Solve25.checkPrime(i)) re += i;
		}
		return re;
	}
}

public class Bai25 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input a number: ");
		int n = sc.nextInt();
		if (n <= 2) System.out.println("Not exist prime number before "+n);
		else System.out.println("The sum of prime number smaller than "+n+ " is "+Solve25.sumPrime(n));
		sc.close();
	}

}
