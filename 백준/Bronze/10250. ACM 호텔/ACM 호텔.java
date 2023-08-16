import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int cnt = 1;
			while(N > H) {
				N -= H;
				cnt++;
			}
			
			sb.append(N).append(String.format("%02d", cnt)).append('\n');
		}
		
		
		System.out.println(sb);
	}

}