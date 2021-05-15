package Question7;

import java.util.HashMap;
import java.util.Map;

public class string {

	public static void main(String[] args) {
		Map<String,Integer> m = new HashMap<>();
		m.put("dhoni", 1);
		m.put("sam",2);
		m.put("moin",3);
		
		StringBuilder s = new StringBuilder();
		m.entrySet().forEach(n -> s.append(n.getKey()).append(n.getValue()));
		System.out.println(s.toString());
		
	}

}
