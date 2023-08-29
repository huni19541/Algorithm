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
				if(i == 0) {
					dp[i][j] = arr[i][j];
					continue;
				}
				if(j == 0) {
					dp[i][j] = arr[i][j] + Math.min(dp[i-1][j+1], dp[i-1][j+2]);
				} else if(j == 1) {
					dp[i][j] = arr[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j+1]);
				} else {
					dp[i][j] = arr[i][j] + Math.min(dp[i-1][j-2], dp[i-1][j-1]);
				}
			}
		}
		
		for(int i=0; i<3; i++) {
			min = dp[N-1][i] < min ? dp[N-1][i] : min;
		}
		
		System.out.println(min);
		
	}

}
