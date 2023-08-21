import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			HashMap<String, Integer> hashmap = new HashMap<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String temp = st.nextToken();
				hashmap.put(temp, hashmap.getOrDefault(temp, 0)+1);
			}

			int sum = 1;
			for(String key : hashmap.keySet()) {
				sum *= (hashmap.get(key) + 1);
			}
			sum -= 1;
			
			sb.append(sum).append('\n');
		}
		
		System.out.println(sb);
	}

}