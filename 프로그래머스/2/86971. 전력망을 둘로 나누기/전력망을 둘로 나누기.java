import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<Integer>[] adjList = new List[n+1];
        for(int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++) {
            adjList[wires[i][0]].add(wires[i][1]);
            adjList[wires[i][1]].add(wires[i][0]);
        }
        
        Queue<Integer> queue;
        boolean[] visited;
        
        for(int i=0; i<wires.length; i++) {
            visited = new boolean[n+1];
            
            int num1 = wires[i][0];
            int num2 = wires[i][1];
            int sum1 = 0;
            int sum2 = 0;
            
            queue = new ArrayDeque<>();
            queue.add(num1);
            visited[num1] = true;
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                sum1++;
                
                for(int j=0; j<adjList[cur].size(); j++) {
                    if((cur == num1 && adjList[cur].get(j) == num2) || (cur == num2 && adjList[cur].get(j) == num1)) {
                        continue;
                    }
                    
                    if(!visited[adjList[cur].get(j)]) {
                        visited[adjList[cur].get(j)] = true;
                        queue.add(adjList[cur].get(j));
                    }
                }
            }
            
            
            queue = new ArrayDeque<>();
            queue.add(num2);
            visited[num2] = true;
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                sum2++;
                
                for(int j=0; j<adjList[cur].size(); j++) {
                    if((cur == num1 && adjList[cur].get(j) == num2) ||(cur == num2 && adjList[cur].get(j) == num1)) {
                        continue;
                    }
                    
                    if(!visited[adjList[cur].get(j)]) {
                        visited[adjList[cur].get(j)] = true;
                        queue.add(adjList[cur].get(j));
                    }
                }
            }
            
            answer = Math.abs(sum1 - sum2) < answer ? Math.abs(sum1 - sum2) : answer;
        }
        
        return answer;
    }
}