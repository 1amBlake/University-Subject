package week1;
import java.util.*;
class Solve22{
	static int inputNum(Scanner sc) {
		int n = 0;
		System.out.print("Please input a number (>0): ");
		n = sc.nextInt();
		return n;
	}
	
	static boolean checkkPrime(int n) {
		double num = Math.sqrt(n);
		if (n == 2) return true;
		else if (n == 1) return false;
		else {
			for (int i = 2; i <= num; i++) {
				if (n % i == 0) return false;
			}
		}
		return true;
	}
}

public class Bai22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Solve22.inputNum(sc);
		if (n <= 0) System.out.println("The number is invalid!");
		else {
			boolean chkPrime = Solve22.checkkPrime(n);
			if (chkPrime) System.out.println(n + " is a prime!");
			else System.out.println(n + " isn't a prime!");
		}
	}

}
