import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int lower = 2;
		for(int i=1; i<=N; i++) {
			lower += Math.pow(2, i-1);
		}
		int res = (int)Math.pow(lower, 2);
		
		sb.append(res);
		System.out.println(sb);
	}

}