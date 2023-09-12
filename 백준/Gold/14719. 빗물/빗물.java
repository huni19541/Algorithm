import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[W];
		
		st = new StringTokenizer(br.readLine());
		
		
		for(int i=0; i<W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		for(int i=2; i<W; i++) {
			for(int j=arr[i]; j>=1; j--) {
				for(int k=i-1; k>=0; k--) {
					if(arr[k] >= j) {
						sum += (i-k-1);
						break;
					}
				}
			}
		}
		
		sb.append(sum);
		
		
		
		System.out.println(sb);

	}

}
