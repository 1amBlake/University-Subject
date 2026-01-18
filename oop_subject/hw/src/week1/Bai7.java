package week1;

class ComparisonDemo{
	public static void main(String[] args) {
		int value1 = 1;
		int value2 = 2;
		System.out.println("value1 == value2: " + (value1 == value2));
		System.out.println("value1 != value2: " + (value1 != value2));
		System.out.println("value1 > value2: " + (value1 > value2));
		System.out.println("value1 < value2: " + (value1 < value2));
		System.out.println("value1 <= value2: " + (value1 <= value2));
		System.out.println("(value1 <= value2) && (value1 == value2): " + ((value1 <= value2) && (value1 == value2)));
		System.out.println("(value1 <= value2) || (value1 == value2): " + ((value1 <= value2) || (value1 == value2)));
		/**
		 * 1. value1 == value2: value1 < value2 => false
		 * 2. value1 != value2: value1 < value2 => true
		 * 3. value1 > value2: value1 < value 2 => false
		 * 4. value1 < value2: value1 < value2 => true
		 * 5. value1 <= value2 <=> value1 < value2 or value1 == value2: value1 < value2 => true
		 * 6. (value1 <= value2) && (value1 == value2) <=> (value1 <= value2) - true AND (value1 == value2) - false => false
		 * 7. (value1 <= value2) || (value1 == value2) <=> (value1 <= value2) - true OR (value1 == value2) - false => true
		 */
	}
}

public class Bai7 {

	public static void main(String[] args) {
		ComparisonDemo.main(args);
	}

}
