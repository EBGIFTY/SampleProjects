package test;

public class ArrayExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		 int[] numbers = { 4,7,12,18,43,75};
		 
		 System.out.println("First number " + numbers[0]);
		 System.out.println("First number " + numbers[1]);
		 System.out.println(numbers.length);
		 System.out.println("Last number " + numbers[numbers.length-1]);
		 
		 String [] names = {"jon", "Adam", "Eva", "nancy"};
		 
		 char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		 
		 String fname = "amandeep";
			char[] ch = fname.toCharArray();
			System.out.println(ch[0]);
			
			String str1 = "my name is nik";
			String [] words = str1.split(" ");
			System.out.println("First word is " + words[0]);
			System.out.println("Second word is " + words[1]);
			

		 
	}


}
