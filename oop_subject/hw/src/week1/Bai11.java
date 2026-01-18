package week1;

class Solve2{
	public static void findOdd(){
		System.out.print("The odd from 1 to 99 is: ");
		for (int i = 1; i <= 99; i++) {
			if (i % 2 != 0) System.out.print(" " + i);
		}
	}
}

public class Bai11 {

	public static void main(String[] args) {
		Solve2.findOdd();
	}

}
