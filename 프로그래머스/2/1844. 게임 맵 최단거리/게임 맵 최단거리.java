import java.io.*;
import java.util.*;

class Solution {
    
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};
    
    static class Info {
        int r;
        int c;
        int dist;
        
        Info(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(0, 0, 1));
        visited[0][0] = true;
        
        boolean flag = false;
        while(!queue.isEmpty()) {
            Info cur = queue.poll();
            
            if(cur.r == (maps.length - 1) && cur.c == (maps[0].length - 1)) {
                answer = cur.dist;
                flag = true;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length) {
                    continue;
                }
                if(maps[nr][nc] == 0 || visited[nr][nc]) {
                    continue;
                }
                
                visited[nr][nc] = true;
                queue.offer(new Info(nr, nc, cur.dist+1));
            }
        }
        
        if(!flag) {
            answer = -1;
        }
        return answer;
    }
}