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

		int N = Integer.parseInt(br.readLine());
		HashSet<String> strs = new HashSet<>();
		for(int i=0; i<N; i++) {
			strs.add(br.readLine());
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(String str : strs)
			list.add(str);
		
		Collections.sort(list, (str1, str2) -> {
			int str1Len = str1.length();
			int str2Len = str2.length();
			
			return (str1Len == str2Len) ? str1.compareTo(str2) : (str1Len - str2Len);
		});
		
		for(String str : list) {
			sb.append(str).append('\n');
		}
		
		System.out.println(sb);
	}
	
}