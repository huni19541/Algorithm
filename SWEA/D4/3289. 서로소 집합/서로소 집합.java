import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] parents = new int[N+1];
			Arrays.fill(parents, -1);
			
			sb.append('#').append(tc).append(" ");
			for(int op=0; op<M; op++) {
				String[] strs = br.readLine().split(" ");
				int first = Integer.parseInt(strs[0]);
				int a = Integer.parseInt(strs[1]);
				int b = Integer.parseInt(strs[2]);
				
				if(first == 0) {
					
					int aRoot = find(parents, a);
					int bRoot = find(parents, b);
					
					if(aRoot == bRoot) continue;
					parents[aRoot] += parents[bRoot];
					parents[bRoot] = aRoot;
				}
				else {
					if(find(parents, a) == find(parents, b))
						sb.append('1');
					else
						sb.append('0');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	private static int find(int[] p, int a) {
		if(p[a] < 0)
			return a;
		return p[a] = find(p, p[a]);
	}

}