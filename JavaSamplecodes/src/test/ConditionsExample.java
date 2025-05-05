package test;

public class ConditionsExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 40;

		if (x == y) {
			
			System.out.println("Both the numbers are matching");
		} else if (x > y) {

			System.out.println("X is greater than Y");
		}else {
			
			System.out.println("Y is greater than X");
		}
		String str1 = "Vibha";
		String str2 = "vibha";
		String str3 = "Gaurav";
		
		if(str1.equalsIgnoreCase(str2)) {
			
			System.out.println("Both the strings are matching");
		}else {
			System.out.println("Both the strings are not matching");
		}
		
		
		if(!str1.equals(str3)) {
			
			System.out.println("Str1 and Str3 are not matching");
		}


	}


}
