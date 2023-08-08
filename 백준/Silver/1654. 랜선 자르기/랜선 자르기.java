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
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		Integer[] lens = new Integer[K];
		long totalLen = 0L;
		for(int i=0; i<K; i++) {
			lens[i] = Integer.parseInt(br.readLine());
			totalLen += lens[i];
		}
		Arrays.sort(lens, Collections.reverseOrder());
		
		//Long max = totalLen / N;
		//if(max > lens[lens.length-1]) max = lens[lens.length-1];
		
		int idx = lens.length-1;
		int res = Integer.MAX_VALUE;
		int max = 0;
		while(res > N) {
			max = lens[idx--];
			
			res = 0;
			for(int i=0; i<K; i++) {
				res += lens[i] / max;
			}
		}
		max = lens[idx+1];
		
		res = 0;
		
		while(res < N) {
			res = 0;
			for(int i=0; i<K; i++) {
				res += lens[i] / max;
			}
			max--;
		}
		
		
		System.out.println(max+1);
	}

}