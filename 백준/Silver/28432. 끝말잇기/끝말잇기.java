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
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		String[] strs = new String[N];
		HashSet<String> hashset = new HashSet<>();
		String str;
		for(int i=0; i<N; i++) {
			str = br.readLine();
			strs[i] = str;
			hashset.add(str);
		}
		
		int idx = 0;
		for(int i=0; i<N; i++) {
			if(strs[i].equals("?")) {
				idx = i;
				break;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			str = br.readLine();
			if(!hashset.contains(str)) {
				if(N == 1)
					sb.append(str);
				else {
					if(idx == 0) {
						if(str.charAt(str.length()-1) == strs[idx+1].charAt(0))
							sb.append(str);
					}
					else if(idx == N-1) {
						if(str.charAt(0) == strs[idx-1].charAt(strs[idx-1].length()-1))
							sb.append(str);
					}
					else {
						if(str.charAt(0) == strs[idx-1].charAt(strs[idx-1].length()-1) && 
								str.charAt(str.length()-1) == strs[idx+1].charAt(0))
							sb.append(str);
					}
				}
			}
		}
				
		System.out.println(sb);
	}

}