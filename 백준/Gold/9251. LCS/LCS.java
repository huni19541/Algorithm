import java.io.*;
import java.util.*;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String s = br.readLine();
		String p = br.readLine();
		
		int sLen = s.length();
		int pLen = p.length();
		
		char[] sArr = new char[sLen+1];
		for(int i=1; i<=sLen; i++) {
			sArr[i] = s.charAt(i-1);
		}
		
		char[] pArr = new char[pLen+1];
		for(int i=1; i<=pLen; i++) {
			pArr[i] = p.charAt(i-1);
		}
		
		
		int[][] dp = new int[pLen+1][sLen+1];
		for(int i=0; i<sLen; i++) {
			dp[0][i] = 0;
		}
		for(int i=0; i<pLen; i++) {
			dp[i][0] = 0;
		}
		
		for(int i=1; i<=pLen; i++) {
			for(int j=1; j<=sLen; j++) {
				if(sArr[j] == pArr[i]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		sb.append(dp[pLen][sLen]);
		
		System.out.println(sb);
	
	}

}
