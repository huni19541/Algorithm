import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] strs;
			boolean check = true;
			for(int i=0; i<N; i++) {
				strs = br.readLine().split(" ");
				char temp = strs[1].charAt(0);
				
				if(strs.length == 4) {
					if(!(temp == '+' || temp == '-' || 
							temp == '*' || temp == '/' ))
							check = false;
				}
				
				else if(strs.length == 2) {
					if(temp == '+' || temp == '-' || 
							temp == '*' || temp == '/')
						check = false;
				}
			}
			
			sb.append('#').append(tc).append(" ");
			if(check) sb.append(1).append('\n');
			else sb.append(0).append('\n');
			
		}
		
		System.out.println(sb);
	}

}