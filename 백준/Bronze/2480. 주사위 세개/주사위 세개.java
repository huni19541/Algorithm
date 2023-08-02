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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(A, map.getOrDefault(A, 0) + 1);
		map.put(B, map.getOrDefault(B, 0) + 1);
		map.put(C, map.getOrDefault(C, 0) + 1);
		
		List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((o1, o2) -> {
			int o1Res = o1.getValue();
			int o2Res = o2.getValue();
			return (o1Res == o2Res) ? o2.getKey() - o1.getKey() : o2Res - o1Res;
		});
		
		int cnt = list.get(0).getValue();
		int num = list.get(0).getKey();
		
		int res = 0;
		if(cnt == 3) {
			res = 10000 + num*1000;
		}
		else if(cnt == 2) {
			res = 1000 + num*100;
		}
		else {
			res = num*100;
		}
		
		sb.append(res);
		System.out.println(sb);
	}

}