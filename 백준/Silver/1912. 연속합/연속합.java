import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] cumulativeSum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			if(cumulativeSum[i-1] < 0)
				cumulativeSum[i] = Integer.parseInt(st.nextToken());
			else
				cumulativeSum[i] = cumulativeSum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++)
			max = Math.max(max,  cumulativeSum[i]);
		
		sb.append(max);
		System.out.println(sb);
	}

}