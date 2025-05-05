package oops;

public class Runnerclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		e1.Name = "Niraj";
		e1.EmpId = 1001;
		e1.Salary = 5000;
		

		e2.Name = "Chandra";
		e2.EmpId = 1002;
		e2.Salary = 5500;
		
		e1.Display();
		e2.Display();

        Stringoperations obj1 = new Stringoperations();
		String rev = obj1.ReverseString("MADAM");
		System.out.println(rev);

		System.out.println(obj1.isPalindrome ("Rohan"));
  
		ConstructorExample student1 = new ConstructorExample("Mike" , 100);
		System.out.println(student1.Name);
		System.out.println(student1.RollNo);
		
		ConstructorExample student2 = new ConstructorExample("harry", 101,5);
	    

StaticExample st1 = new StaticExample("Jatin",200);
	StaticExample st2 = new StaticExample("Asad",201);
	StaticExample st3 = new StaticExample("Varsha",202);
		
	System.out.println(st1.name);
	System.out.println(st1.rollNo);
	System.out.println(StaticExample.institute);
		
	st1.rollNo = 300;
	StaticExample.institute = "Howard";	
	StaticExample.displayInst();


	AccessModifier ac1 = new AccessModifier();
	ac1.name = "Henry";
	ac1.rollNo = 100;
	ac1.std = 5;
	ac1.setInstitute("Oxford"); // private var
	System.out.println(ac1.getInstitute()); // private var
	

	ChildClass child1 = new ChildClass();
	child1.phoneNo = 12345;
	child1.name = "Rohan";
	child1.rollNo = 100;
	child1.std = 5;








	}

}
