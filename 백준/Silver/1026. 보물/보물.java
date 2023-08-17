import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		Integer[] B = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			B[i] = Integer.valueOf(st.nextToken());
		
		Arrays.sort(A);
		Arrays.sort(B, (o1, o2) -> o2-o1);
		
		int sum = 0;
		for(int i=0; i<N; i++)
			sum += (A[i]*B[i].intValue());
		sb.append(sum);
		
		System.out.println(sb);
	}

}