import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    public static class Info {
        String str;
        int cnt;
        
        public Info(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean isContain = false;
        Set<String> set = new HashSet<>();
        for(int i=0; i<words.length; i++) {
            set.add(words[i]);
            if(words[i].equals(target)) {
                isContain = true;
            }
        }
        
        if(!isContain) {
            return 0;
        }
        
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(begin, 0));
        
        while(!queue.isEmpty()) {
            Info cur = queue.poll();
            if(cur.str.equals(target)) {
                answer = cur.cnt;
                break;
            }
            
            Set<String> removeSet = new HashSet<>();
            for(String word : set) {
                if(isPossible(cur.str, word)) {
                    removeSet.add(word);
                    queue.offer(new Info(word, cur.cnt+1));
                }
            }
            
            for(String removeWord : removeSet) {
                set.remove(removeWord);
            }
            
        }
            
        return answer;
    }
    
    public static boolean isPossible(String str, String str2) {
        
        int length = str.length();
        int count = 0;
        
        for(int i=0; i<length; i++) {
            if(str.charAt(i) == str2.charAt(i)) {
                count++;
            }
        }
        
        if(count == length - 1) {
            return true;
        }
        
        return false;
    }
}