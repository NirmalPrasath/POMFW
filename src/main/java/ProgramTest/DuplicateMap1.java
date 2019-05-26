package ProgramTest;

import java.util.HashMap;
import java.util.Map.Entry;

public class DuplicateMap1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, String> map=new HashMap<>();
		
		
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "one");
		map.put(5, "four");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "four");
		HashMap<Integer, String> newMap=new HashMap<>();
		
		for(Entry<Integer, String> entry:map.entrySet())
		{
			if(!newMap.containsValue(entry.getValue()))
			{
				newMap.put(entry.getKey(), entry.getValue());
			}
			
			else {
				
				System.out.println("Duplicate: " + entry.getKey() + " = " + entry.getValue());
				//newMap.remove( );
			}
			
				
		}
		
		System.out.println("After remove duplicate: " + newMap);
		
		

	}

}
