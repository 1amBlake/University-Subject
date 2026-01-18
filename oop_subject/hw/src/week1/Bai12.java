package week1;

class Solve10{
	public static void result() {
		System.out.print("The result is ");
		for (int i = 1; i <= 100; i++) {
			if (i % 7 == 0) System.out.print(" " + i);
		}
	}
}

public class Bai12 {

	public static void main(String[] args) {
		Solve10.result();

	}

}
