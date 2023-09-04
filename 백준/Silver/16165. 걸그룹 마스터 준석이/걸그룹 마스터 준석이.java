import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, ArrayList<String>> hashmap = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String team = br.readLine();
			int members = Integer.parseInt(br.readLine());
			
			ArrayList<String> memberList = new ArrayList<>();
			for(int j=0; j<members; j++) {
				memberList.add(br.readLine());
			}
			
			hashmap.put(team, memberList);
		}
		
		for(int i=0; i<M; i++) {
			String oper = br.readLine();
			int opNum = Integer.parseInt(br.readLine());
			
			if(opNum == 1) {
				for(String key : hashmap.keySet()) {
					if(hashmap.get(key).indexOf(oper) != -1) {
						sb.append(key).append('\n');
					}
				}
			}
			else {
				ArrayList<String> list = hashmap.get(oper);
				Collections.sort(list);
				for(String member : list) {
					sb.append(member).append('\n');
				}
			}
		}
		
		System.out.println(sb);
	}

}