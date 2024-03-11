import java.io.*;
import java.util.*;

class Solution {
    
    public static int[] num1 = {1, 2, 3, 4, 5};
    public static int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
    public static int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] count = new int[4];
        int max = 0;
        
        for(int i=0; i<answers.length; i++) {
            // 1번 수포자
            if(num1[i % num1.length] == answers[i]) {
                count[1]++;
                if(count[1] > max) {
                    max = count[1];
                }
            }
            
            // 2번 수포자
            if(num2[i % num2.length] == answers[i]) {
                count[2]++;
                if(count[2] > max) {
                    max = count[2];
                }
            }
            
            // 3번 수포자
            if(num3[i % num3.length] == answers[i]) {
                count[3]++;
                if(count[3] > max) {
                    max = count[3];
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=3; i++) {
            if(count[i] == max) {
                list.add(i);
            }
        }
        
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
}

