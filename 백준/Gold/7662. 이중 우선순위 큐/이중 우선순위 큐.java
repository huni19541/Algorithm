import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> pqMin = new PriorityQueue<>();
			HashMap<Integer, Integer> hashmapMax = new HashMap<>();
			HashMap<Integer, Integer> hashmapMin = new HashMap<>();
			int K = Integer.parseInt(br.readLine());
			
			int insertCnt = 0;
			
			for (int i = 0; i < K; i++) {
				String[] strs = br.readLine().split(" ");

				if (strs[0].equals("I")) {
					int inputNum = Integer.parseInt(strs[1]);
					
					pqMax.offer(inputNum);
					pqMin.offer(inputNum);
					insertCnt++;
				} 
				else {
					if(insertCnt == 0)
						continue;
					
					if (strs[1].equals("-1")) {
						int first = pqMin.peek();
						
						while(hashmapMax.containsKey(first)) {
							for(int j=0; j<hashmapMax.get(first); j++) {
								pqMin.poll();
							}
							hashmapMax.remove(first);
							first = pqMin.peek();
						}
						
						pqMin.poll();
						hashmapMin.put(first, hashmapMin.getOrDefault(first, 0)+1);
					} 
					else {
						int first = pqMax.peek();
						
						while(hashmapMin.containsKey(first)) {
							for(int j=0; j<hashmapMin.get(first); j++) {
								pqMax.poll();
							}
							hashmapMin.remove(first);
							first = pqMax.peek();
						}
						
						pqMax.poll();
						hashmapMax.put(first, hashmapMax.getOrDefault(first, 0)+1);
					}
					
					insertCnt--;
				}
			}

			if (insertCnt != 0) {
				int max = pqMax.peek();
				
				while(hashmapMin.containsKey(max)) {
					for(int j=0; j<hashmapMin.get(max); j++) {
						pqMax.poll();
					}
					hashmapMin.remove(max);
					
					max = pqMax.peek();
				}
				sb.append(max).append(" ");
				
				int min = pqMin.peek();
				
				while(hashmapMax.containsKey(min)) {
					for(int j=0; j<hashmapMax.get(min); j++) {
						pqMin.poll();
					}
					hashmapMax.remove(min);
					
					min = pqMin.peek();
				}
				sb.append(min).append(" ");
			}
			else
				sb.append("EMPTY\n");
		}

		System.out.println(sb);
	}
}