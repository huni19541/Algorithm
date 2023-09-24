import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	Queue<long[]> queue = new ArrayDeque<>();
    	
    	st = new StringTokenizer(br.readLine());
    	long A = Integer.parseInt(st.nextToken());
    	long B = Integer.parseInt(st.nextToken());
    	
    	queue.offer(new long[] {A, 1});
    	boolean check = false;
    	while(!queue.isEmpty()) {
    		long[] cur = queue.poll();
    		
    		if(cur[0] == B) {
    			check = true;
    			sb.append(cur[1]);
    		}
    		
    		if(cur[0]*2 <= B) {
    			queue.offer(new long[] {cur[0]*2, cur[1]+1});
    		}
    		
    		if(cur[0]*10+1 <= B) {
    			queue.offer(new long[] {cur[0]*10+1, cur[1]+1});
    		}
    	}
    	
    	if(!check) sb.append(-1);
    	
    	System.out.println(sb);
    }
}