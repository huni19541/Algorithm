import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	static int res = 0;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = br.readLine();
		
		int idx = 0, cnt = 0;
		while(idx < str.length()) {
			char c = str.charAt(idx);
			
			if(c == 'c') {
				if((idx < str.length()-1) && str.charAt(idx+1) == '=') {
					idx += 2;
					cnt++;
					continue;
				}
				if((idx < str.length()-1) && str.charAt(idx+1) == '-') {
					idx += 2;
					cnt++;
					continue;
				}
			}
			else if(c == 'd') {
				if((idx < str.length()-2) && str.charAt(idx+1) == 'z') {
					if(str.charAt(idx+2) == '=') {
						idx += 3;
						cnt++;
						continue;
					}
				}
				if((idx < str.length()-1) && str.charAt(idx+1) == '-') {
					idx += 2;
					cnt++;
					continue;
				}
			}
			else if(c == 'l') {
				if((idx < str.length()-1) && str.charAt(idx+1) == 'j') {
					idx += 2;
					cnt++;
					continue;
				}
			}
			else if(c == 'n') {
				if((idx < str.length()-1) && str.charAt(idx+1) == 'j') {
					idx += 2;
					cnt++;
					continue;
				}
			}
			else if(c == 's') {
				if((idx < str.length()-1) && str.charAt(idx+1) == '=') {
					idx += 2;
					cnt++;
					continue;
				}
			}
			else if(c == 'z') {
				if((idx < str.length()-1) && str.charAt(idx+1) == '=') {
					idx += 2;
					cnt++;
					continue;
				}
			}
			idx++;
			cnt++;
		}
		
		sb.append(cnt);
		
		
		System.out.println(sb);
	}
	
}