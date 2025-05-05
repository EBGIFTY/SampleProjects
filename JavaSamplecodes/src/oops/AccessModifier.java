package oops;

public class AccessModifier {
	String name;   // default access modifier
	public int rollNo;  // public access mod
	protected int std;  // protected access mod
	private String institute;  // private access mod
	
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	
	public String getInstitute() {
		return this.institute;
	}


}
