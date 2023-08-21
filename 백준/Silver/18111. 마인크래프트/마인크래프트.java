import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] map = new int[N*M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i*M+j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(map);
		int h = map[0];
		
		int min = Integer.MAX_VALUE;
		int minHeight = 0;
		outer:
		while(h <= map[map.length-1]) {
			int[] temp = Arrays.copyOf(map, map.length);
			int b = B;
			int time = 0;
			boolean check = true;
			for(int i=N-1; i>=0; i--) {
				for(int j=M-1; j>=0; j--) {
					
					int cur = temp[i*M+j];
					if(cur > h) {
						int gap = cur - h;
						time += (2 * gap);
						b += gap;
					}
					
					if(cur < h) {
						int gap = h - cur;
						if(b >= gap) {
							time += gap;
							b -= gap;
						}
						else {
							check = false;
							break outer;
						}
					}
				}
			}
			
			if(min >= time) {
				min = time;
				minHeight = h;
			}
			h++;
		}
		
		sb.append(min).append(" ").append(minHeight);
		System.out.println(sb);
	}
	
}