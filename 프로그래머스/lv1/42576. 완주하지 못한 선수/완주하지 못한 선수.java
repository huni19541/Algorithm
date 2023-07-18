import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String s1 : participant)
        {
        	if(map.containsKey(s1))
        		map.replace(s1, map.get(s1)+1);
        	
        	else
            	map.put(s1, 1);
        }
        
        for(String s2 : completion)
        	map.replace(s2, map.get(s2)-1);
        
        for(Map.Entry<String, Integer> m : map.entrySet())
        {
        	if(m.getValue() == 1)
        	{
        		answer = m.getKey();
        		break;
        	}
        }
        
        return answer;
    }
}