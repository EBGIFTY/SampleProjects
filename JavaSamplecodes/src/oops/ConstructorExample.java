package oops;

public class ConstructorExample{

	String Name;
	int RollNo;
	int std;
	
	public ConstructorExample(String name, int rollNo) {
		
		this.Name = name;
		this.RollNo = rollNo;
	}
	public ConstructorExample(String name, int rollNo, int std) {

		this.Name = name;
		this.RollNo = rollNo;
		this.std = std;
	}
}

