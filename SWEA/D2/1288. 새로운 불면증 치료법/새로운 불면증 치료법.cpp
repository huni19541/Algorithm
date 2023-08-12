import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int compare = (1<<10) - 1;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine());
			int count = 0;
			
			int numBit = 0;
			int temp;
			
			while((numBit & compare) != compare) {	
				count++;
				temp = num* count;
				while(temp > 0) {
					numBit |= (1 << ((temp % 10)));
					temp /= 10;
				}
			
			}
			
			sb.append('#').append(tc).append(" ").append(num*count).append('\n');
		}
		System.out.println(sb);

	}

}