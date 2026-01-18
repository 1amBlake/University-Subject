package week1;
import java.util.*;

class Solve24{
	static int inputN(Scanner sc) {
		int in = sc.nextInt();
		return in;
	}
	
	static int calSum(int n) {
		int re = 0;
		for (int i = 1; i <= n; i++) re += i;
		return re;
	}
}

public class Bai24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Solve24.inputN(sc);
		int re = Solve24.calSum(n);
		System.out.println("The result is " + re);
	}

}
