package week1;
import java.util.*;
class Solve14{
	public static void cal(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			if (n % 2 != 0 && i % 2 != 0) sum += i;
			else if (n % 2 == 0 && i % 2 == 0) sum += i;
		}
		System.out.println("The result is " + sum);
	}
}

public class Bai14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input n: ");
		int n = sc.nextInt();
		if (n <= 0) System.out.println("n is invalid!");
		else Solve14.cal(n);
		sc.close();
	}

}
