import java.io.*;
import java.util.*;

class Solution {
    
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        visited = new boolean[dungeons.length];
        find(dungeons, k, 0, 0);
        answer = max;
        
        return answer;
    }
    
    public static void find(int[][] dungeons, int k, int clear, int cnt) {
        if(cnt == dungeons.length) {
            max = clear > max ? clear : max;
            return;
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(k >= dungeons[i][0]) {
                    find(dungeons, k-dungeons[i][1], clear+1, cnt+1);
                } else {
                    find(dungeons, k, clear, cnt+1);
                }
                visited[i] = false;
            }
        }
        
    }
}