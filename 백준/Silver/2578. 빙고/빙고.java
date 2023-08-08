import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		int[] dr = {-1, 0, -1, 1}; // 좌 상 좌상 우상
		int[] dc = {0, -1, -1, -1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		HashMap<Integer, int[]> hashmap = new HashMap<>();
		boolean[][] check = new boolean[5][5];
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				hashmap.put(Integer.parseInt(st.nextToken()), new int[] {i, j});
			}
		}
		
		int bingoCnt = 0;
		int cnt = 0;
		int nc = 0, nr = 0;
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				cnt++;
				int[] index = hashmap.get(Integer.parseInt(st.nextToken()));
				int curY = index[0], curX = index[1]; 
				check[curY][curX] = true;
				
				for(int k=0; k<4; k++) {
					int tempCnt = 1;
					nc = curY + dc[k];
					nr = curX + dr[k];
					
					while(nc < 5 && nr < 5 && nc >= 0 && nr >= 0 && check[nc][nr]) {
						nc += dc[k];
						nr += dr[k];
						tempCnt++;
					}
					
					nc = curY - dc[k];
					nr = curX - dr[k];
					while(nc < 5 && nr < 5 && nc >= 0 && nr >= 0 && check[nc][nr]) {
						nc -= dc[k];
						nr -= dr[k];
						tempCnt++;
					}
					if(tempCnt == 5) bingoCnt++;
				}
				
				if(bingoCnt >= 3) {
					sb.append(cnt);
					System.out.println(sb);
					return;
				}
			}
		}
		
		
	}

}