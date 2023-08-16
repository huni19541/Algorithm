import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String str = br.readLine();
		int idx = 0, sum = 0;
		while(idx < str.length()) {
			char c = str.charAt(idx);
			if(c - 'A' < 3) sum += 3;
			else if(c - 'A' < 6) sum += 4;
			else if(c - 'A' < 9) sum += 5;
			else if(c - 'A' < 12) sum += 6;
			else if(c - 'A' < 15) sum += 7;
			else if(c - 'A' < 19) sum += 8;
			else if(c - 'A' < 22) sum += 9;
			else if(c - 'A' < 26) sum += 10;
			else if(c == '1') sum += 2;
			else if(c == 0) sum += 11;
			
			idx++;
		}
		sb.append(sum);
		System.out.println(sb);
	}

}