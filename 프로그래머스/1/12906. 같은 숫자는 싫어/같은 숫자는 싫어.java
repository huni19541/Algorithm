import java.io.*;
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> answerQueue = new ArrayDeque<>();
        for(int i=0; i<arr.length; i++) {
            queue.offer(arr[i]);
        }
        
        int prev = -1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur != prev) {
                answerQueue.offer(cur);
            }
            prev = cur;
        }
        
        int idx = 0;
        answer = new int[answerQueue.size()];
        while(!answerQueue.isEmpty()) {
            int cur = answerQueue.poll();
            answer[idx++] = cur;
        }

        return answer;
    }
}