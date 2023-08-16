import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int[] numCnt = new int[10];
		int num = A*B*C;
		
		while(num > 0) {
			numCnt[num%10]++;
			num /= 10;
		}
		for(int i=0; i<10; i++) {
			sb.append(numCnt[i]).append('\n');
		}
		
		
		System.out.println(sb);
	}

}