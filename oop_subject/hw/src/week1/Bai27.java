package week1;
import java.util.*;
class Solve27{
	static int inputN(Scanner sc) {
		System.out.print("Please input amount of fibonaci to output: ");
		int n = sc.nextInt();
		return n;
	}
	static void outputFibon(int n) {
		long a = 1, b = 1;
		System.out.print("The fibon is "+a+" "+b+" ");
		for (int i = 3; i <= n; i++) {
			long c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}
}
public class Bai27 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Solve27.inputN(sc);
		if ( n < 1) System.out.println("The value inputed is invalid!");
		else {
			Solve27.outputFibon(n);
		}
	}

}
