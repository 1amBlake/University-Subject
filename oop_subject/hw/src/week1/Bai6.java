package week1;

class ArithmeticDemo{
	public static void main(String[] args) {
		int result = 1 + 2;
		result = result - 1;
		result = result * 2;
		result = result / 2;
		result = result + 8;
		result = result % 7;
		System.out.println("final result: " + result);
		/**
		 * 1. result = 1 + 2 = 3
		 * 2. result = 3 - 1 = 2
		 * 3. result = 2 * 2 = 4
		 * 4. result = 4 / 2 = 2
		 * 5. result = 2 + 8 = 10
		 * 6. result = 10 % 7 = 3
		 * => final result: 3
		 */
	}
}

class ConcatDemo{
	public static void main(String[] args) {
		String firstString = "This is";
		String secondString = " a concatenated string.";
		String thirdString = firstString + secondString;
		System.out.println(thirdString);
		/**
		 * firstString concatenate to secondString
		 * => "This is a concatenated string."
		 */
	}
}

class UnaryDemo{
	public static void main(String[] args) {
		int result = +1;
		System.out.println(result);
		
		result--;
		System.out.println(result);
		
		result++;
		System.out.println(result);
		
		result = -result;
		System.out.println(result);
		
		boolean success = false;
		System.out.println(success);
		System.out.println(!success);
		
		/**
		 * 1. result = 1
		 * 2. result = 0
		 * 3. result = 1
		 * 4. result = -1
		 * 
		 * success = false
		 * value = false, condition = true => print: false
		 * value = false, condition = false => print: true
		 * 
		 */
	}
}

class PrePostDemo{
	public static void main(String[] args) {
		int i = 3;
		i++;
		System.out.println(i);
		++i;
		System.out.println(i);
		System.out.println(++i);
		System.out.println(i++);
		System.out.println(--i);
		System.out.println(i--);
		System.out.println(i);
		
		/**
		 *i = 3
		 *i increase latter: 3 + 1 = 4
		 *print 4
		 *i increase first: 4 + 1 =5
		 *print 5
		 *i increase first: 5 + 1 = 6 -> print latter 6
		 *i increase latter: 6 + 1 = 7 -> print first 6
		 *i decrease first: 7 - 1 = 6 -> print latter 6
		 *i decrease latter: 6 - 1 = 5 -> print first 6
		 *print 5
		 */
	}
}

public class Bai6 {
	public static void main(String[] args) {
		ArithmeticDemo.main(args);
		ConcatDemo.main(args);
		UnaryDemo.main(args);
		PrePostDemo.main(args);
	}
}
