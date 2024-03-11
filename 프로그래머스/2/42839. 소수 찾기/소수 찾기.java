import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] visited;
    static String[] nums;
    static Set<Integer> set;
    
    public int solution(String numbers) {
        int answer = 0;
        
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        nums = numbers.split("");
        find("");
        for(int i : set) {
            System.out.println(i);
            if(isPrime(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void find(String str) {
        if(!str.isEmpty()) {
            set.add(Integer.parseInt(str));
        }
        
        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                find(str+nums[i]);
                visited[i] = false;
            }
        }
        
    }
}