package test;

public class SpringExample {
	public static void main(String[] args) {
		System.out.println("Alan");

		System.out.println("Alan Sugae");

		String fname = "Alan";
		String lname = "Sugae";

		System.out.println(fname);
		System.out.println(lname);

		String Fullname = fname + " " + lname;
		System.out.println(Fullname.length());

		System.out.println(Fullname.toUpperCase());
		System.out.println(Fullname.toLowerCase());

		System.out.println(Fullname.charAt(9));
		System.out.println(Fullname.charAt(Fullname.length() - 1));

		String Newname = Fullname.replace("Sugae", "Parker");
		System.out.println(Newname);
		
		boolean check = Newname.contains("Parker");
		System.out.println(check);
		
		char c= 'A';
		System.out.println(Newname.indexOf(c));
	}

}
