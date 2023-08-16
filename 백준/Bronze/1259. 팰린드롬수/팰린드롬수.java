import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			StringBuilder sb2 = new StringBuilder();
			String str = br.readLine();
			
			if(str.equals("0")) break;
			sb2.append(str);
			String str2 = sb2.reverse().toString();
			
			if(str.equals(str2)) sb.append("yes\n");
			else sb.append("no\n");
			
		}
		
		System.out.println(sb);
	}

}