import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(visited[i]) {
                continue;
            }
            
            Queue<Integer> queue = new ArrayDeque<>();
            visited[i] = true;
            queue.offer(i);
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int j=0; j<n; j++) {
                    if(cur == j) {
                        continue;
                    }
                    
                    if(visited[j] || computers[cur][j] == 0) {
                        continue;
                    }
                    
                    visited[j] = true;
                    queue.offer(j);
                }
            }
            
            answer++;
        }
        return answer;
    }
}