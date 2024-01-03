import java.util.*;
import java.io.*;

public class Main {

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R, C, K, count;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[R+1][C+1];
        visited = new boolean[R+1][C+1];
        for(int i=1; i<=R; i++) {
            String str = br.readLine();
            for(int j=1; j<=C; j++) {
                map[i][j] = str.charAt(j-1);
            }
        }

        visited[R][1] = true;
        find(R, 1, 1);

        sb.append(count);
        System.out.println(sb);
    }

    public static void find(int r, int c, int cnt) {
        if(r == 1 && c == C) {
            if(cnt == K) {
                count++;
            }
            return;
        }

        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr > 0 && nr <= R && nc > 0 && nc <= C && map[nr][nc] == '.' && !visited[nr][nc]) {
                visited[nr][nc] = true;
                find(nr, nc, cnt+1);
                visited[nr][nc] = false;
            }
        }
    }
}