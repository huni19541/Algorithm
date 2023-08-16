import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			if(n == -1)
				break;
			
			int sum = 0;
			
			for(int i=1; i<n; i++) {
				if(n % i == 0) {
					sum += i;
					list.add(i);
				}
			}
			
			
			if(sum != n) {
				sb.append(n).append(" is NOT perfect.\n");
			}
			else {
				sb.append(n).append(" = ");
				for(int i=0; i<list.size(); i++) {
					if(i == list.size()-1)
						sb.append(list.get(i)).append('\n');
					else
						sb.append(list.get(i)).append(" + ");
				}
			}
		}
		
		System.out.println(sb);
	}

}