package week1;
import java.util.*;

class Solve29{
	static void shapeA(int M, int N) {
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				if (i <= N) {
					if(j <= i) System.out.print("* ");
					else System.out.print("  ");
				}
			}
			System.out.print("\n");
		}
		System.out.println();
	}
	static void shapeB(int M, int N) {
		for (int i = M; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("* ");
			}
			System.out.print("\n");
		}
		System.out.println();
	}
	static void shapeC(int M) {
		for (int i = 1; i <= M; i++) {
	        for (int j = 1; j <= M - i; j++) {
	            System.out.print("  ");
	        }
	        for (int k = 1; k <= 2 * i - 1; k++) {
	            System.out.print("* ");
	        }
	        System.out.println();
	    }
	    System.out.println();
	}
	static void shapeD(int M) {
		for (int i = 1; i <= M; i++) {
	        for (int j = 1; j <= M - i; j++) {
	            System.out.print("  ");
	        }
	        for (int k = 1; k <= 2 * i - 1; k++) {
	            if (i == M || k == 1 || k == 2 * i - 1) {
	                System.out.print("* ");
	            } else {
	                System.out.print("  ");
	            }
	        }
	        System.out.println();
	    }
	    System.out.println();
	}
}

public class Bai29 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap M: ");
		int M = sc.nextInt();
		System.out.print("Nhap N: ");
		int N = sc.nextInt();
		if (M <= 1 || N <= 1) System.out.println("The data is invalid");
		else {
			Solve29.shapeA(M, N);
			Solve29.shapeB(M, N);
			Solve29.shapeC(M);
			Solve29.shapeD(M);
		}
		sc.close();
	}

}
