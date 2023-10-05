import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		sb.append(iter(A, B, C));
		
		System.out.println(sb);
		
	}
	
	private static int iter(int a, int b, int c) {
		if(b == 1) {
			return a%c;
		}
		
		long res = iter(a, b/2, c);
		long result = res*res;
		result %= c;
		if(b % 2 != 0) {
			result *= a;
			result %= c;
		}
		return (int) result;
	}
}