import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N+1];
		long[] tree = new long[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			
			int cur = i;
			while(cur <= N) {
				tree[cur] += arr[i];
				int lsb = cur&-cur;
				cur += lsb;
			}
		}
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				long diff = c - arr[b];
				
				int cur = b;
				while(cur <= N) {
					tree[cur] += diff;
					int lsb = cur&-cur;
					cur += lsb;
				}
				
				arr[b] = c;
			} else if(a == 2) {
				long subSum1 = 0;
				
				int cur = (int)c;
				while(cur > 0) {
					subSum1 += tree[cur];
					int lsb = cur&-cur;
					cur -= lsb;
				}
				
				long subSum2 = 0;
				cur = b-1;
				while(cur > 0) {
					subSum2 += tree[cur];
					int lsb = cur&-cur;
					cur -= lsb;
				}
				
				sb.append(subSum1 - subSum2).append('\n');
			}
		}
		
		System.out.println(sb);

	}

}