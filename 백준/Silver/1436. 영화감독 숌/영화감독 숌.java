import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] arr = new int[10001];
		arr[1] = 666;
		int idx = 2;
		
		int N = Integer.parseInt(br.readLine());
		
		int num = 1000;
		while(idx <= 10000) {
			String s = String.valueOf(num);
			if(s.contains("666"))
				arr[idx++] = num;
			num++;
		}
		Arrays.sort(arr, 1, 10000);
		sb.append(arr[N]);
		
		System.out.println(sb);
	}

}