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
		
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(scores);
		int max = scores[scores.length - 1];
		
		double sum = 0;
		for(int i=0; i<N; i++) {
			sum += (double)scores[i]/max*100;
		}
		
		sb.append(sum/N);
		
		System.out.println(sb);
	}

}