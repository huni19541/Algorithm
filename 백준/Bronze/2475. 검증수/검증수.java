import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());

		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		
		sb.append(sum%10);
		
		System.out.println(sb);
	}

}