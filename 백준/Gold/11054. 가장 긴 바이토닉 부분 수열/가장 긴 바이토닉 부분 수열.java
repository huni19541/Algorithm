import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dpLeft = new int[N];
		int[] dpRight = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dpLeft[0] = 1;
		for(int i=1; i<N; i++) {
			
			boolean check = false;
			for(int j=i-1; j>=0; j--) {
				if(arr[i] > arr[j]) {
					check = true;
					dpLeft[i] = Math.max(dpLeft[i], dpLeft[j] + 1);
				}
			}
			if(!check) {
				dpLeft[i] = 1;
			}
		}
		
		dpRight[N-1] = 1;
		for(int i=N-1; i>=0; i--) {
			
			boolean check = false;
			for(int j=i+1; j<N; j++) {
				if(arr[i] > arr[j]) {
					check = true;
					dpRight[i] = Math.max(dpRight[i], dpRight[j] + 1);
				}
			}
			if(!check) {
				dpRight[i] = 1;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			int sum = dpLeft[i] + dpRight[i];
			
			max = Math.max(max, sum-1);
		}
		
		sb.append(max);
		System.out.println(sb);
	}

}