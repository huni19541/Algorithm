import java.io.*;
import java.util.*;

public class Main {
	
	static class Info{
		int x;
		int y;
		int idx;
		
		Info(int x, int y, int idx){
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Info[] arr = new Info[N];
		int[] res = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
		}
		
		Arrays.sort(arr, (o1, o2) -> (o1.x == o2.x) ? o1.y - o2.y : o1.x - o2.x);
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr[i].x < arr[j].x && arr[i].y < arr[j].y) {
					res[arr[i].idx]++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(res[i]+1).append(" ");
		}
		
		System.out.println(sb);
	}

}