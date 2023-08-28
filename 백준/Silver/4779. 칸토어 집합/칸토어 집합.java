import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String str;
		while((str = br.readLine()) != null) {
			int N = Integer.parseInt(str);
			
			N = (int)Math.pow(3, N);
			boolean[] check = new boolean[N];
			
			dq(N, 0, check);
			for(int i=0; i<N; i++) {
				if(!check[i]) {
					sb.append('-');
				}
				else {
					sb.append(" ");
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	private static void dq(int size, int start, boolean[] check) {
		if(size == 1) return;
		
		int temp = size/3;
		for(int i=start+temp; i<start+2*temp; i++) {
			check[i] = true;
		}
		
		dq(temp, start, check);
		dq(temp, start+2*temp, check);
	}

}