package oops;

public class Stringoperations {
	
	
	public String ReverseString(String str1) {
		
		String result = "";

		for (int i = str1.length() - 1; i >= 0; i--) {

			result = result + str1.charAt(i);
		}
		
		return result;
	}

public boolean isPalindrome(String str1) {
		
		boolean result = str1.equals(ReverseString(str1));
		return result;


}
}






