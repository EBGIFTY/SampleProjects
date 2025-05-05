package collections;

import java.util.HashSet;
import java.util.Set;

public class SetExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> names = new HashSet<String>();
		names.add("Chandra");
		names.add("Harshal");
		names.add("Indika");
		names.add("Chandra");
		System.out.println(names);
		
		
		String str1 = "Clean World Green World Happy World";
		
		// find out the total number of unique words in the above string
		
		String [] Words = str1.split(" ");
		Set<String> UniqueNames = new HashSet<String>();

		
		for(String word : Words) {
			
			UniqueNames.add(word);
		}
		
		System.out.println(UniqueNames);
		System.out.println("Unique words are " + UniqueNames.size());
	}

}
