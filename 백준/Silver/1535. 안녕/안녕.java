import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] L = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}

		int[] J = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[101];

		for (int i = 0; i < N; i++) {
			for (int j = 99; j >= 0; j--) {
				if (j >= L[i]) {
					dp[j] = Math.max(dp[j], dp[j - L[i]] + J[i]);
				}
			}
		}

		sb.append(dp[99]);

		System.out.println(sb);

	}

}