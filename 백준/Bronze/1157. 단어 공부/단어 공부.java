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
		
//		T = Integer.parseInt(br.readLine());
		int[] count = new int[26];
		
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c >= 97) c -= 32;
			
			count[(int)c - 65]++;
		}
		
		int max = Integer.MIN_VALUE;
		int maxIdx = 0;
		for(int i=0; i<26; i++) {
			if(count[i] > max) {
				max = count[i];
				maxIdx = i;
			}
		}
		
		boolean check = false;
		for(int i=0; i<26; i++) {
			if(i == maxIdx) continue;
			if(max == count[i]) {
				check = true;
				break;
			}
		}
		
		if(check) sb.append('?');
		else sb.append((char)(maxIdx+65));
		
		
		System.out.println(sb);
	}
	
}