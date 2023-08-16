import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int X = Integer.parseInt(br.readLine());
		
		int idx = 1, cnt = 2;
		while(X > idx) {
			X -= idx;
			cnt++;
			idx++;
		}
		
		if(cnt % 2 == 1) {
			sb.append(X).append('/').append(cnt-X);
		}
		else {
			sb.append(cnt-X).append('/').append(X);
		}
		
		System.out.println(sb);
	}

}