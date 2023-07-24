import java.util.HashMap;
import java.util.Arrays;

class Solution {
  public boolean solution(String[] phone_book) {
		
		Arrays.sort(phone_book);
		
		for(int i = 0; i< phone_book.length - 1; i++) {
			for(int j = i + 1; j < phone_book.length; j++) {
				if(phone_book[j].startsWith(phone_book[i]))
					return false;
                else
                    break;
			}
		}
		return true;
	}
	
	public boolean solution2(String[] phone_book) {
		
		HashMap<String, Integer> map = new HashMap<>();
		for(String s : phone_book)
			map.put(s, map.getOrDefault(s, 0) + 1);
		
		for(String s : map.keySet()) {
			for(int i=0; i<s.length(); i++) {
				if(map.containsKey(s.substring(0, i)))
					return false;
			}
		}
		return true;
	}
}