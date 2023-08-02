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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
//		int N = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		
		int[] alpha = new int[26];
		for(int i=0; i<alpha.length; i++) {
			alpha[i] = -1;
		}
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(alpha[(int)c - 97] == -1) {
				alpha[(int)c - 97] = i;
			}
		}
		
		for(int n : alpha) {
			sb.append(n).append(" ");
		}
		
		
		System.out.println(sb);
	}
	
}