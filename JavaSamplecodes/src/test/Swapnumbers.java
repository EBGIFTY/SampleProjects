package test;

public class Swapnumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 30;
		int y = 15;
		System.out.println("Before Swap");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
 
        int temp = x;
        x = y;
        y = temp;
 
        System.out.println("After swap");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        
       System.out.println("another method");
        int z = y;
		y = x;
		x = z;

		System.out.println("X = " + x);
		System.out.println("Y = " + y);
		
		 System.out.println("another method");

		int p = 100;
		int q = 89;

		p = p + q; // 62
		q = p - q; // 62 - 12 = 50
		p = p - q; // 62 - 50 = 12

		System.out.println("P =" + p);
		System.out.println("Q = "+ q);
		

       
    }

	}

