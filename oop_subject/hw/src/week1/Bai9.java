package week1;
import java.util.*;

//if-else / switch-case

class IfElseDemo{
	public static void main(String[] args) {
		int testscore = 76;
		char grade;
		if (testscore >= 90) grade = 'A';
		else if (testscore >= 80) grade = 'B';
		else if (testscore >= 70) grade = 'C';
		else if (testscore >= 60) grade = 'D';
		else grade = 'F';
		System.out.println("Grade: " + grade);
	}
}

class SwitchDemo{
	public static void main(String[] args) {
		int month = 8;
		String monthString;
		switch(month) {
			case 1:
				monthString = "January";
			break;
			case 2:
				monthString = "February";
			break;
			case 3:
				monthString = "March";
			break;
			case 4:
				monthString = "April";
			break;
			case 5:
				monthString = "May";
			break;
			case 6:
				monthString = "June";
			break;
			case 7:
				monthString = "July";
			break;
			case 8:
				monthString = "August";
			break;
			case 9:
				monthString = "September";
			break;
			case 10:
				monthString = "October";
			break;
			case 11:
				monthString = "November";
			break;
			case 12:
				monthString = "December";
			break;
			default:
				monthString = "Invalud month!";
				break;
		}
		System.out.println(monthString);
	}
}

//loop

class ForDemo{
	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) {
			System.out.println("Count is: " + i);
		}
	}
}

class WhileDemo{
	public static void main(String[] args) {
		int count = 1;
		while (count < 11) {
			System.out.println("Count is: " + count);
			count++;
		}
	}
}

class DoWhileDemo{
	public static void main(String[] args) {
		int count = 1;
		do {
			System.out.println("Count is: " + count);
			count++;
		}while(count < 11);
	}
}

//random

class RandomExercise{
	public static void main(String[] args) {
		int min = -100;
		int max = 100;
		Random r = new Random();
		Random rndNumbers = new Random();
		int il = r.nextInt(max - min + 1) + min; //Limited
		int rndNumber = rndNumbers.nextInt(); //Unlimited
		System.out.println(il + " And " + rndNumber);
	}
}

public class Bai9 {

	public static void main(String[] args) {
		IfElseDemo.main(args);
		SwitchDemo.main(args);
		
		ForDemo.main(args);
		WhileDemo.main(args);
		DoWhileDemo.main(args);
		
		RandomExercise.main(args);
	}

}
