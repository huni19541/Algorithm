import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		int v = Integer.parseInt(br.readLine());
		if(map.get(v) == null) sb.append(0);
		else sb.append(map.get(v));
		
		System.out.println(sb);
	}

}