package week1;
import java.util.*;

class Solve23{
	static int findUSCLN(int a, int b) {
		int re = 0;
		for (int i = 2; i <= a; i++) {
			if (b % i == 0 && a % i == 0)  re = i;
		}
		return re;
	}
}

public class Bai23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input first number: ");
		int a = sc.nextInt();
		System.out.print("Please input second number: ");
		int b = sc.nextInt();
		int re = Solve23.findUSCLN(a, b);
		if (re == 0) System.out.println(a+" va "+b+" co USCLN la 1");
		else System.out.println("USCLN cua "+a+" va "+b+" la "+re);
		sc.close();
	}

}
