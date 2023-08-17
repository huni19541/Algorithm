import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int sum = 1;
		for(int i=N; i>N-K; i--)
		{
			sum *= i;
			sum /= (N-i+1);
		}
		sb.append(sum);
		
		System.out.println(sb);
	}

}