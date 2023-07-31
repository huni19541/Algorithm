import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[19][19];
	static int[] dr = new int[] {0, 1, 1, 1}; // 하 우하 우 우상
	static int[] dc = new int[] {1, 1, 0, -1}; // 하 우하 우 우상
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		//////////////////////////////////////////////////////////////
		// 테스트 후 아래 파일 입력을 표준입력으로 처리하는 문장은 주석 처리해주세요!!!! ( System.setIn처리 코드 )
		//////////////////////////////////////////////////////////////
		//System.setIn(new FileInputStream("Test5.txt"));
		
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		check();
		
	}
	
	static void check() {
		
		int res = 0;
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(map[i][j] == 0) continue;
				
				int curColor = map[i][j];
				
				for(int k=0; k<4; k++) {
					cnt = 1;
					find(i, j, curColor, k);
					
					if(cnt == 5) {
						int pc = i-dc[k];
						int pr = j-dr[k];
						if(pc >= 0 && pc < 19 && pr >= 0 && pr < 19) {
							if(map[pc][pr] != curColor) {
								res = (curColor == 1) ? 1 : 2;
								System.out.println(res);
								System.out.println((i+1)+" "+(j+1));
								return;
							}
						}
						if(pc < 0 || pc >= 19 || pr < 0 || pr >= 19) {
							res = (curColor == 1) ? 1 : 2;
							System.out.println(res);
							System.out.println((i+1)+" "+(j+1));
							return;
						}
						
					}
				}
			}
		}
		System.out.println(res);
	}
	
	static void find(int col, int row, int curColor, int curDirection) {
		int nc = col + dc[curDirection];
		int nr = row + dr[curDirection];
		
		if(nc >= 0 && nc < 19 && nr >= 0 && nr < 19) {
			if(map[nc][nr] != curColor) {
				return;
			}
			
			cnt++;
			find(nc, nr, curColor, curDirection);
		}
		
		
	}
	
}

