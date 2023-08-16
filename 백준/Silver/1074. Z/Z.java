import java.util.*;
import java.io.*;

public class Main {

	static int res;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
//
//		int sum = 0;
//		if(N == 1) {
//			if(C % 2 == 1)
//				sum += 1;
//			if(R % 2 == 1)
//				sum += 2;
//			sb.append(sum);
//		}
//		else {
////			sum += ((R / 2)*(int)(Math.pow(2, N-1))*4) + ((C/2)*4);
////			int res1 = ((R / (int)(Math.pow(2, (2*(N-1)-2)))) * 4 * 2);
//			int res1 = ((R / (int)(Math.pow(2, N-1))) * 4 * 2 * (int)(Math.pow(2, (2*(N-1)-2))));
////			int res2 = (C / (int)(Math.pow(2, (2*(N-1)-2))) * 4);
//			int res2 = (C / (int)(Math.pow(2, N-1)) * 4 * (int)(Math.pow(2, (2*(N-1)-2))));
//			sum += (res1 + res2);
//			
//			if(C >= (int)(Math.pow(2, N-1))) {
//				C -= (int)(Math.pow(2, N-1));
//			}
//			
//			if(R >= (int)(Math.pow(2, N-1))) {
//				R -= (int)(Math.pow(2, N-1));
//			}
//		
//			
//			
//			
//			if(C % 2 == 1)
//				sum += 1;
//			if(R % 2 == 1)
//				sum += 2;
//			
//			sb.append(sum);
//		}
		find(N, R, C);

		sb.append(res);
		System.out.println(sb);
	}
	
	private static void find(int n, int r, int c) {
		if(n == 1) {
			if(r % 2 == 1) res += 2;
			if(c % 2 == 1) res += 1;
			return;
		}
		
		int curC = c;
		int curR = r;
		int size = (int)(Math.pow(2, n-1));
		if(r >= size && c >= size) {
			res += (size/2)*(size/2)*4*3;
			curC -= size;
			curR -= size;
		}
		else if(r >= size) {
			res += (size/2)*(size/2)*4*2;
			curR -= size;
		}
		else if(c >= size) {
			res += (size/2)*(size/2)*4;
			curC -= size;
		}
		
		find(n-1, curR, curC);
	}

}