import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	Queue<Integer> queue = new ArrayDeque<>();
  
    	int max = Integer.MIN_VALUE;
    	int sum = 0;
    	for(int i=0; i<K-1; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		queue.offer(num);
    		sum += num;
    	}
    	
    	for(int i=K-1; i<N; i++){
    		int num = Integer.parseInt(st.nextToken());
    		queue.offer(num);
    		sum += num;
    		max = Math.max(max, sum);
    		sum -= queue.poll();
    	}
    	
    	sb.append(max);
    	
    	System.out.println(max);
    }
}