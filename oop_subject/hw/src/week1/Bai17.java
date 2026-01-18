package week1;
import java.util.*;

class Solve17{
	static void checkNum(int n) {
		if (n == 0) System.out.println("Number is Zero!");
		else if (n % 2 == 0 && n != 0) System.out.println("Number is Even!");
		else if (n % 2 != 0) System.out.println("Number is Odd!");
	}
}

public class Bai17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input a number: ");
		int n = sc.nextInt();
		Solve17.checkNum(n);
		sc.close();
	}

}
