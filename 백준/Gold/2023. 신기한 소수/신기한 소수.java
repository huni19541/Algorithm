import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		findPrime(0, 0);
		
		System.out.println(sb);
	}
	
	private static void findPrime(int n, int num) {
		if(n == N) {
			sb.append(num).append('\n');
			return;
		}
		
		for(int i=0; i<=9; i++) {
			int cur = num*10 + i;
			
			if(isPrime(cur))
				findPrime(n+1, cur);
		}
		
	}
	
	private static boolean isPrime(int n) {
		if(n == 0 || n == 1) return false; 
		
		for(int i=2; i*i<=n; i++) {
			if(n%i == 0)
				return false;
		}
		return true;
	}
}