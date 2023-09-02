import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
			PriorityQueue<Integer> minPQ = new PriorityQueue<>();
			
			List<Integer> res = new ArrayList<>();
			
			int root = 0, prevNum = 0;
			int smallerCnt = 0, largerCnt = 0, cnt = 0;
			for(int i=0; i<N; i++) {
				cnt++;
				
				if(cnt % 10 == 1) {
					st = new StringTokenizer(br.readLine());
				}
				
				int num = Integer.parseInt(st.nextToken());
				
				if(cnt == 1) {
					root = num;
					res.add(num);
					prevNum = num;
					continue;
				}
				
				if(num > root) largerCnt++;
				else if(num < root) smallerCnt++;
				
				if(cnt % 2 == 1) {
					if(smallerCnt == 2) {
						minPQ.offer(root);
						maxPQ.offer(prevNum);
						maxPQ.offer(num);
						root = maxPQ.poll();
					}
					else if(largerCnt == 2) {
						maxPQ.offer(root);
						minPQ.offer(prevNum);
						minPQ.offer(num);
						root = minPQ.poll();
					}
					else {
						if(prevNum < num) {
							maxPQ.offer(prevNum);
							minPQ.offer(num);
						}
						else {
							maxPQ.offer(num);
							minPQ.offer(prevNum);
						}
					}

					smallerCnt = 0;
					largerCnt = 0;
					
					res.add(root);
				}
				
				else {
					prevNum = num;
				}
				
				
			}
			
			int len = res.size();
			sb.append(len).append('\n');
			
			for(int i=1; i<=len; i++) {
				sb.append(res.get(i-1)).append(" ");
				if(i % 10 == 0) {
					sb.append('\n');
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb);

	}

}