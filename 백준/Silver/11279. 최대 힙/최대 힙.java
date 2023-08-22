import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
       
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int op=0; op<N; op++) {
        	int num = Integer.parseInt(br.readLine());
        	
        	if(num == 0) {
        		if(pq.isEmpty()) {
        			sb.append("0\n");
        		}
        		else
        			sb.append(-pq.poll()).append('\n');
        	}
        	else {
        		pq.offer(-num);
        	}
        }
        
        System.out.println(sb);
    }
}