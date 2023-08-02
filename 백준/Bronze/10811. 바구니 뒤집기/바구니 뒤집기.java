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
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i=0; i<arr.length; i++)
			arr[i] = i+1;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int[] temp = Arrays.copyOfRange(arr, start-1, end);
			for(int j=start-1; j<end; j++) {
				arr[j] = temp[end-1-j];
			}
		}
		
		for(int n : arr) {
			sb.append(n).append(" ");
		}
		
		System.out.println(sb);
	}
	
}