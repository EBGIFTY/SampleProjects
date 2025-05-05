package test;

public class ReversalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "my name is jatin";

		String result = "";

		for (int i = str1.length() - 1; i >= 0; i--) {
			
			result = result + str1.charAt(i);
			
			// result = "" + 'n';
			// result = "n" + 'i';
			// result = "ni" + 't';
			// result = "nit" + 'a';	
		}
		
		System.out.println(result);
int x= 23062024;
int y = 0;
int z=0;
while (x > 0) {
			y = x % 10;
			x = x / 10;
			z = z * 10 + y; 
			System.out.println(y + " and " + x + " and " + z);	
		}
		
		System.out.println(z);


	}

}
