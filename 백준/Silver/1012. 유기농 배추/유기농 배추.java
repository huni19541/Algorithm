import java.util.Scanner;

public class Main {

	static int T, M, N, K, X, Y;
	static int[][] map;
	static boolean[][] check;
	
	final static int[] dc = {-1, 1, 0, 0}; // 상 하 좌 우
	final static int[] dr = {0, 0, -1, 1}; // 상 하 좌 우
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int test_case=0; test_case<T; test_case++)
		{
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][M];
			check = new boolean[N][M];
			
			for(int i=0; i<K; i++)
			{
				X = sc.nextInt();
				Y = sc.nextInt();
				
				map[Y][X] = 1;
			}
			
			
			
			countWarm();
		}
		
		
		sc.close();
	}
	
	static void countWarm()
	{
		int cnt = 0;
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				if(map[i][j] == 0 || check[i][j] == true)
					continue;
				
				if(map[i][j] == 1 && check[i][j] == false)
				{
					check[i][j] = true;
					find(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
	static void find(int col, int row)
	{
		for(int k=0; k<4; k++)
		{
			int nc = col + dc[k];
			int nr = row + dr[k];
			
			if(nc >= 0 && nc < N && nr >= 0 && nr < M)
			{
				if(!check[nc][nr] && map[nc][nr] == 1)
				{
					check[nc][nr] = true;
					find(nc, nr);
				}
			}
		}
	}
}
