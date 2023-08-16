import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int sum = 0;
		for(int i=0; i<str.length(); i++) {
			sum += (int)(str.charAt(i)-96)*(int)(Math.pow(31, i));
		}
		sum %= 1234567891;
		sb.append(sum);
		
		System.out.println(sb);
	}

}