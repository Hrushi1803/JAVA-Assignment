package Question4;

import java.util.ArrayList;
import java.util.List;

public class Odd1 {
	public static void main(String[] args) {
		List<String> ls= new ArrayList<>();
		ls.add("Ram");
		ls.add("Shyam");
		ls.add("radhe");
		ls.add("Smith");
		ls.add("Washii");
		ls.add("Natrajan");
		
		ls.forEach(i -> {  
            if (i.length() % 2 == 0) { //check for even length of string  
                System.out.println(i); 
		//ls.removeIf(n -> n%2!=0);//check for odd length of string
		//System.out.println(ls);
            }  
        });  
    }  
} 