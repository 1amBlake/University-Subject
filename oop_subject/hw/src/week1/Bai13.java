package week1;
import java.util.*;

class Solve13{
	public static int cal(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += n;
		}
		return sum;
	}
}

public class Bai13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input n: ");
		int n = sc.nextInt();
		if (n <= 0) System.out.println("n is invalid!");
		else System.out.println("The result is " + Solve13.cal(n));
		sc.close();

	}

}
