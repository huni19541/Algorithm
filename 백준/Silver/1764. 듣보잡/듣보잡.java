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
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> comp = new HashMap<>();
		HashMap<String, Integer> result = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			comp.put(br.readLine(), 1);
		}
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(comp.containsKey(str)) {
				result.put(str, 1);
			}
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(String s : result.keySet()) {
			list.add(s);
		}
		
		Collections.sort(list);
		sb.append(list.size()).append('\n');
		for(String s : list)
			sb.append(s).append('\n');
		
		System.out.println(sb);
	}

}