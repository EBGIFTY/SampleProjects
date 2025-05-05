package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String[] names = {"name1","name2","name3"};
		
		List<String> names = new ArrayList<>();
		names.add("Chandra");
		names.add("Harshal");
		names.add("Indika");
		
		// Print the values inside the arraylist
		System.out.println(names);
        System.out.println("The first value in list is " + names.get(0));
		System.out.println("The second value in list is " + names.get(1));
		System.out.println("The third value in list is " + names.get(2));
		System.out.println("Total values inside the list " + names.size());
		
		// remove Indika from list
		names.remove(2);
		System.out.println(names);
		
		// add Asad to the list
		names.add("Asad");
		System.out.println(names);
		
		// update the name to Aasad
		names.set(2, "Aasad");
		System.out.println(names);

		// loop through the array list
		for(String n: names) {
			System.out.println(n);
		}
		
		// sort the array list using collections
		Collections.sort(names);
		System.out.println(names);
		
		// Linked list example
				List<String> names2 = new LinkedList<>();

	}
}

