package week1;
import java.util.*;

class Solve21{
	static void output(String s) {
		StringTokenizer st = new StringTokenizer(s);
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}

public class Bai21 {

	public static void main(String[] args) {
		String s = "Bai Tap Mon Lap Trinh Java";
		Solve21.output(s);
	}

}
