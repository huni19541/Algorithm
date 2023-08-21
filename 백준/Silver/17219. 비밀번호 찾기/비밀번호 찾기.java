import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hashmap = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String[] strs = br.readLine().split(" ");
			hashmap.put(strs[0], strs[1]);
		}
		
		for(int i=0; i<M; i++) {
			sb.append(hashmap.get(br.readLine())).append('\n');
		}
		
		System.out.println(sb);
	}

}