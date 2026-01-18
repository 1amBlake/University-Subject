package week1;
import java.util.*;

class Solve26{
	static int inputNum(Scanner sc) {
		System.out.print("Please input amount of Prime want to sum: ");
		int n = sc.nextInt();
		return n;
	}
	static boolean checkPrime(int n) {
		if (n <= 1) return false;
		else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) return false; 
			}
			return true;
		}
	}
	static void outputSum(int n) {
		if (n < 1) System.out.println("The input value is invalid!");
		else {
			int re = 0, i = 0;
			while (n > 0) {
				if (Solve26.checkPrime(i)) {
					re += i;
					n--;
				}
				i++;
			}
			System.out.println("The sum of prime is "+re);
		}
	}
}


public class Bai26 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Solve26.inputNum(sc);
		Solve26.outputSum(n);
	}
}
