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

				// 입력일 때는 pq 둘다에 offer
				if (strs[0].equals("I")) {
					int inputNum = Integer.parseInt(strs[1]);
					
					pqMax.offer(inputNum);
					pqMin.offer(inputNum);

					// insertCnt++
					insertCnt++;
				} 
				// 출력일 때
				else {
					// 비어있는 경우 continue
					if(insertCnt == 0)
						continue;

					// -1인 경우 -> 최소값 뽑기
					// 최대힙에서 뺀 값을 저장해놓은 최대해시맵에 현재 peek가 있으면 제거
					if (strs[1].equals("-1")) {
						int first = pqMin.peek();
						
						while(hashmapMax.containsKey(first)) {
							for(int j=0; j<hashmapMax.get(first); j++) {
								pqMin.poll();
							}
							hashmapMax.remove(first);
							first = pqMin.peek();
						}

						// 더이상 없는 경우 최소값 뽑기
						pqMin.poll();
						// 뽑은 값 최소해시맵에 저장
						hashmapMin.put(first, hashmapMin.getOrDefault(first, 0)+1);
					} 
					// 최대값 뽑기
					// 최소힙에서 뺀 값을 저장해놓은 최소해시맵에 현재 peek가 있으면 제거
					else {
						int first = pqMax.peek();
						
						while(hashmapMin.containsKey(first)) {
							for(int j=0; j<hashmapMin.get(first); j++) {
								pqMax.poll();
							}
							hashmapMin.remove(first);
							first = pqMax.peek();
						}

						// 더이상 없는 경우 최대값 뽑기
						pqMax.poll();
						// 뽑은 값 최대해시맵에 저장
						hashmapMax.put(first, hashmapMax.getOrDefault(first, 0)+1);
					}
					
					insertCnt--;
				}
			}

			// 입력이 끝났을 때, insertCnt가 남아있다면 위에서 해던 작업 반복
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
