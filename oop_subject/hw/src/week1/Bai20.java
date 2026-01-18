package week1;
import java.util.*;

class Solve20{
	static String inputString(Scanner sc) {
		System.out.print("Please input a string: ");
		String s = sc.nextLine();
		return s;
	}
	
	static int countDigit(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) count++;
		}
		return count;
	}
	
	static void output(int count, String s) {
		System.out.println("There are " + count + " digits in String \"" + s + "\"");
	}
}

public class Bai20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = Solve20.inputString(sc);
		int count = Solve20.countDigit(s);
		Solve20.output(count, s);
		sc.close();
	}

}
