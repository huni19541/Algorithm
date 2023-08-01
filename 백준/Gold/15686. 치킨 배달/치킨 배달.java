import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N = 0;
	static int M = 0;
	static int[][] map;
	static boolean[][] check;
	static int Min = Integer.MAX_VALUE;

	// 치킨집의 x, y좌표 저장할 클래스 
	static class Pos{
		private int x;
		private int y;
		
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	// 치킨집의 좌표 저장할 ArrayList
	static ArrayList<Pos> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		check = new boolean[N][N];

		// 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		select(0, M);
		System.out.println(Min);
	}

	// M개의 치킨집 선택하는 함수
	static void select(int idx, int M) {
		if(M == 0) {
			calc();
			return;
		}
		
		for(int i=idx; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 2 && check[i][j] == false) {
					// 조건에 맞으면 list에 추가한 후, boolean : true
					list.add(new Pos(j, i));
					check[i][j] = true;
					
					// M-1로 재귀호출
					select(i, M-1);
					
					//재귀가 리턴되면 list 맨 뒤 제거 후, boolean : false
					list.remove(list.size()-1);
					check[i][j] = false;
				}
			}
		}
	}

	// 선택된 M개의 치킨집으로의 가장 작은 치킨거리 계산
	static void calc() {
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					int min = Integer.MAX_VALUE;
					
					for(int k=0; k<list.size(); k++) {
						int subSum = Math.abs(i-list.get(k).y) + Math.abs(j-list.get(k).x);
						min = min > subSum ? subSum : min;
					}
					
					sum += min;
				}
			}
		}
		
		Min = Min > sum ? sum : Min;
	}
}
