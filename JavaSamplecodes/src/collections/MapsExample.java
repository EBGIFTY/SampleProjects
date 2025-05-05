package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// minister
		// PM - Modi
		// FM - Nirmla
		// DM - Rajnath
		// HM - Amit
		
		Map<String, String> ministers = new HashMap<String, String>();
		
		ministers.put("PM", "Modi");
		ministers.put("FM", "Nirmla");
		ministers.put("DM", "Rajnath");
		ministers.put("HM", "Amit");
		
		System.out.println(ministers);
		
		// Update the DM to Nitin
		ministers.put("DM", "Nitin");
		System.out.println(ministers);
		
		// Remove HM from map
		ministers.remove("HM");
		System.out.println(ministers);
		
		// get a value of PM
		System.out.println("The PM is " + ministers.get("PM"));
		System.out.println("==============");
		
		// Iterate through map
		
		Set<String> keys = ministers.keySet();
		
		for(String k: keys) {
			System.out.println("Key is " + k);
			System.out.println("Value is " + ministers.get(k));
			System.out.println("==============");
		}
		String str1 = "Clean World  Green World Happy World";
		

		// Find out the occurrence of each word in the above string
		
		// Clean - 1
		// Green - 1
		// Happy - 1
		// World - 3
String[] str = str1.split(" ");
		
		Set<String> keys1 = new HashSet<String>();
		for(String s:str) {
			keys1.add(s);
		}
		
		
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		for(String k:keys1) {
			int count = 0;
			for(int i=0; i<str.length; i++) {
				if(str[i].equals(k)) {
					count++;
				}
			}
			map.put(k, count);
		}
		System.out.println(map);


		
		

		
	}

}


