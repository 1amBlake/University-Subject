package week1;
class Solve28{
	static void shapeFirst() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i < 9) {
					if (j == i || j == 1) System.out.print("* ");
					else System.out.print("  ");
				}
				else System.out.print("* ");
			}
			System.out.print("\n");
		}
		System.out.println();
	}
	static void shapeSecond() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i == 1 || i == 9) System.out.print("* ");
				else {
					if (i == j || i + j == 10 || j == 1 || j == 9) System.out.print("* ");
					else System.out.print("  ");
				}
			}
			System.out.print("\n");
		}
		System.out.println();
	}
	static void shapeThird() {
		for(int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i == 5) System.out.print("* ");
				else {
					if (i == j || i + j == 10) System.out.print("* ");
					else System.out.print("  ");
				}
			}
			System.out.print("\n");
		}
	}
}
public class Bai28 {

	public static void main(String[] args) {
		Solve28.shapeFirst();
		Solve28.shapeSecond();
		Solve28.shapeThird();
	}

}
