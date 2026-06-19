package demoRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		String input = "Abc\ndef";
		String patternStr = "abc$";
		
		Pattern pattern = Pattern.compile(patternStr, Pattern.MULTILINE |
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		boolean matcherFound = matcher.find();
		System.out.println(matcherFound);

	}

}
