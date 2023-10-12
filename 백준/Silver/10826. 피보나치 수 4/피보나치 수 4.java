import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		BigInteger[] dp = new BigInteger[10001];
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		sb.append(dp[N]);
		System.out.println(sb);
	}

}