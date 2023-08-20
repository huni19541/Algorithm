import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int temp = 1;
		
		for(int i=2; i<=N; i++) {
			temp *= i;
			
			while(temp%10 == 0) {
				temp /= 10;
				cnt++;
			}

			temp %= 1000;
		}
		
		sb.append(cnt);
		

		System.out.println(sb);
	}

}