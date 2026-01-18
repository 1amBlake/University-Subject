package week1;
import java.util.*;

class Solve19{
	static String inputString(Scanner sc) {
		System.out.print("Please input string: ");
		String str = sc.nextLine();
		return str;
	}
	
	static int Count(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') count++;
		}
		return count;
	}
	
	static void output(int count, String str) {
		System.out.println("There are " + count + " 'a' in \"" + str + "\"");
	}
}

public class Bai19 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = Solve19.inputString(sc);
		int cou = Solve19.Count(s);
		Solve19.output(cou, s);
		sc.close();
	}

}
