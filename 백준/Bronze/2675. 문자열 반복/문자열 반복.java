import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				for(int k=0; k<R; k++) {
					sb.append(c);
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
}