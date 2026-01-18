package week1;
import java.util.*;

class Solve15{
	public static int min(int A[], int n) {
		int min = A[0];
		for (int i = 0; i < n; i++) {
			if (A[i] < min) min = A[i];
		}
		return min;
	}
	
	public static int max(int A[], int n) {
		int max = A[0];
		for (int i = 0; i < n; i++) {
			if (A[i] > max) max = A[i];
		}
		return max;
	}
	
	public static void inputArray(int A[], int n, Scanner sc) {
		for (int i = 0; i < n; i++) {
			System.out.print("A["+i+"] = ");
			A[i] = sc.nextInt();
		}
	}
}

public class Bai15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input size of array: ");
		int n = sc.nextInt();
		if (n <= 0) System.out.println("Size of array is invalid!");
		else {
			int[] Arr = new int[n];
			Solve15.inputArray(Arr, n, sc);
			int max = Solve15.max(Arr, n);
			int min = Solve15.min(Arr, n);
			System.out.println("Max: " + max + " Min: " + min);
		}

	}

}
