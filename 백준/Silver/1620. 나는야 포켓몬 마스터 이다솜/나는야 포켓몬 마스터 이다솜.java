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
		
		HashMap<String, Integer> hashmap = new HashMap<>();
		String[] arr = new String[N+1];
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			hashmap.put(str, i);
			arr[i] = str;
		}
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			
			if(Character.isDigit(str.toCharArray()[0])) {
				sb.append(arr[Integer.parseInt(str)]).append('\n');
			}
			else {
				sb.append(hashmap.get(str)).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}