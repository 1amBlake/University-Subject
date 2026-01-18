package week1;
import java.util.*;

class Solve16{
	public static double cal(int a, int b) {
		double x;
		x = -b / (double) a;
		return x;
	}
}

public class Bai16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ax + b = 0 \na = ");
		int a = sc.nextInt();
		System.out.print("b = ");
		int b = sc.nextInt();
		if (a == 0) System.out.println("x is invalid!");
		else System.out.println("x is " + Solve16.cal(a, b));
		sc.close();
	}

}
