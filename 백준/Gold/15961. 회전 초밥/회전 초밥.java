import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new ArrayDeque<>();
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		int[] arr = new int[k-1];
		int arrIdx = 0;
		
		int max = Integer.MIN_VALUE;
		int cnt = 0;
		for(int i=0; i<k-1; i++) {
			int num = Integer.parseInt(br.readLine());
			queue.offer(num);
			arr[i] = num;
			if(!hashmap.containsKey(num)) {
				cnt++;
				hashmap.put(num, 1);
			}
			else {
				hashmap.put(num, hashmap.get(num)+1);
			}
			
		}
		
		for(int i=k-1; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			queue.offer(num);
			
			if(!hashmap.containsKey(num)) {
				cnt++;
				hashmap.put(num, 1);
			}
			else {
				hashmap.put(num, hashmap.get(num)+1);
			}
			
			if(!hashmap.containsKey(c))
				max = Math.max(max, cnt+1);
			else
				max = Math.max(max, cnt);
			
			int peek = queue.poll();
			hashmap.put(peek, hashmap.get(peek)-1);
			
			if(hashmap.get(peek) == 0) {
				hashmap.remove(peek);
				cnt--;
			}
		}
		
		for(int i=0; i<k-1; i++) {
			int num = arr[i];
			queue.offer(num);
			
			if(!hashmap.containsKey(num)) {
				cnt++;
				hashmap.put(num, 1);
			}
			else {
				hashmap.put(num, hashmap.get(num)+1);
			}
			
			if(!hashmap.containsKey(c))
				max = Math.max(max, cnt+1);
			else
				max = Math.max(max, cnt);
			
			int peek = queue.poll();
			hashmap.put(peek, hashmap.get(peek)-1);
			
			if(hashmap.get(peek) == 0) {
				hashmap.remove(peek);
				cnt--;
			}
		}
		
		sb.append(max);
		System.out.println(sb);
		
	}

}