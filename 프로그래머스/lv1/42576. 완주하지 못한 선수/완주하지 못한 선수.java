import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		for(String s : participant)
			map.put(s, map.getOrDefault(s, 0)+1);
		
		for(String s : completion)
			map.put(s, map.get(s)-1);
		
		for(Entry<String, Integer> entryset : map.entrySet()) {
			if(entryset.getValue() == 1) {
				answer = entryset.getKey();
			}
		}
		
		return answer;
	}
}