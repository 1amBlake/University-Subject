package week1;

class Solve18{
	static void find() {
		System.out.print("The result is ");
		for (int i = 300; i >= 3; i--) {
			if (i % 3 == 0) System.out.print(i + " ");
		}
	}
}

public class Bai18 {

	public static void main(String[] args) {
		Solve18.find();
	}

}
