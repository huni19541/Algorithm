import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<N; i++) {
			
			// 초기값
			if(i == 0) {
				dp[i] = arr[i];
			}
			else if(i == 1) {
				dp[i] = arr[i-1] + arr[i];
			}
			else if(i == 2) {
				dp[i] = Math.max(dp[i-1], Math.max(+arr[i-1]+arr[i], dp[i-2]+arr[i]));
			}
			
			// 경우를 3가지로 나눈다.
			// 경우 1 : 현재 포도주를 안마시는 경우
			// 경우 2 : 이전 것과 현재 포도주를 2연속으로 마시는 경우
			// 경우 3 : 이전 것을 안마시는 경우
			else {
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]));
			}
		}
		
		System.out.println(dp[N-1]);
	}

}
