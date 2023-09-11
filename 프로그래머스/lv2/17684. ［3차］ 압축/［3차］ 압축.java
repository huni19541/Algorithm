import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        HashMap<String, Integer> hashmap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        int cnt = 1;
        for(cnt=1; cnt<=26; cnt++) {
            char c = (char)(cnt + 'A' - 1);
            hashmap.put(Character.toString(c), cnt);
        }
        
        int idx = 0;
        
        while(idx < msg.length()) {
            int tempIdx = msg.length();
            
            while(tempIdx > idx) {
                String temp = msg.substring(idx, tempIdx);
                
                if(hashmap.containsKey(temp)) {
                    int newValue = hashmap.get(temp);
                    list.add(newValue);
                    
                    if(tempIdx < msg.length()){
                        int appendValue = hashmap.get(Character.toString(msg.charAt(tempIdx)));
                        hashmap.put(temp.concat(Character.toString(msg.charAt(tempIdx))), cnt++);
                    }
                    
                    break;
                }
                
                tempIdx--;
            }
            
            idx = tempIdx;
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}