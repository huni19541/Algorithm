import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			if(i==0) {
				for(int j=0; j<2*N-1; j++) {
					sb.append('*');
				}
				sb.append('\n');
			}
			
			else {
				int temp = i;
				sb.insert(0, '\n');
				while(temp > 0) {
					sb.append(" ");
					temp --;
				}
				
				for(int j=i; j<2*N-1-i; j++) {
					sb.insert(0, '*');
					sb.append('*');
				}
				
				temp = i;
				while(temp > 0) {
					sb.insert(0, " ");
					temp --;
				}
				
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
}