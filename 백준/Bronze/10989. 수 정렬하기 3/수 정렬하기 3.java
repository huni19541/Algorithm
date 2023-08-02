import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
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
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		
		for(int i=0; i<T; i++) {
			int num = Integer.parseInt(br.readLine());
			
			arr[i] = num;
		}
		Arrays.sort(arr);
		
		for(int n : arr) {
			sb.append(n).append('\n');
		}
		
		
		
		System.out.println(sb);
	}
	
}