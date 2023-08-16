import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			if(n1 == 0 && n2 == 0)
				break;
			
			if(n1 % n2 == 0)
				sb.append("multiple\n");
			else if(n2 % n1 == 0)
				sb.append("factor\n");
			else
				sb.append("neither\n");
			
		}
		
		System.out.println(sb);
	}

}