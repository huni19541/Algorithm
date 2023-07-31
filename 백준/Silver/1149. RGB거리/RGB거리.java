import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N = 0;
	static int[][] arr;
	static int[][] dp;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][3];
		dp = new int[N][3];
		
		for(int i=0; i<N; i++) {
			String[] numStrs = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(numStrs[0]);
			arr[i][1] = Integer.parseInt(numStrs[1]);
			arr[i][2] = Integer.parseInt(numStrs[2]);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++) {
				// dp 초기값 설정
				if(i == 0) {
					dp[i][j] = arr[i][j];
					continue;
				}
				// 다른 색 중에서 작은 값으로 dp 저장
				if(j == 0) {
					dp[i][j] = arr[i][j] + Math.min(dp[i-1][j+1], dp[i-1][j+2]);
				} else if(j == 1) {
					dp[i][j] = arr[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j+1]);
				} else {
					dp[i][j] = arr[i][j] + Math.min(dp[i-1][j-2], dp[i-1][j-1]);
				}
			}
		}

		// 맨 밑에 저장된 dp값들 중에서 최소값 출력
		for(int i=0; i<3; i++) {
			min = dp[N-1][i] < min ? dp[N-1][i] : min;
		}
		
		System.out.println(min);
		
	}

}
