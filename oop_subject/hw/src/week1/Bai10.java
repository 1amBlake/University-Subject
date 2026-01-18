package week1;

class Solve{
	public static void findEven(){
		int count = 0, i = 0, sum = 0;
		while(count < 10) {
			if (i % 2 == 0) {
				count++;
				sum += i;
			}
			i++;
		}
		System.out.print("The sum is " + sum);
	}
}

public class Bai10 {

	public static void main(String[] args) {
		Solve.findEven();

	}

}
