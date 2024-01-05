import java.io.*;
import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] S;
    static int[] L;
    static int[] E;
    static int count;
    
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
    
    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') {
                    S = new int[]{i, j};
                }
                else if(map[i][j] == 'L') {
                    L = new int[]{i, j};
                }
                else if(map[i][j] == 'E') {
                    E = new int[]{i, j};
                }
            }
        }
        
        Queue<Info> queue = new ArrayDeque<>();
        visited = new boolean[map.length][map[0].length];
        queue.offer(new Info(S[0], S[1], 0));
        visited[S[0]][S[1]] = true;
        
        boolean flag1 = false;
        while(!queue.isEmpty()) {
            Info cur = queue.poll();
            System.out.println("r: "+cur.r+", c: "+cur.c);
            if(map[cur.r][cur.c] == 'L') {
                flag1 = true;
                count += cur.dist;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr >= 0 && nr < maps.length && nc >= 0 && nc < maps[0].length()) {
                    if(map[nr][nc] == 'X' || visited[nr][nc]) {
                        continue;
                    }
                    visited[nr][nc] = true;
                    queue.offer(new Info(nr, nc, cur.dist+1));
                }
            }
        }
        if(!flag1) {
            return -1;
        }
        
        queue = new ArrayDeque<>();
        visited = new boolean[map.length][map[0].length];
        queue.offer(new Info(L[0], L[1], 0));
        visited[L[0]][L[1]] = true;
        boolean flag2 = false;
        while(!queue.isEmpty()) {
            Info cur = queue.poll();
            if(map[cur.r][cur.c] == 'E') {
                flag2 = true;
                count += cur.dist;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr >= 0 && nr < maps.length && nc >= 0 && nc < maps[0].length()) {
                    if(map[nr][nc] == 'X' || visited[nr][nc]) {
                        continue;
                    }
                    visited[nr][nc] = true;
                    queue.offer(new Info(nr, nc, cur.dist+1));
                }
            }
        }
        if(!flag2) {
            return -1;
        }
        
        int answer = count;
        return answer;
    }
}