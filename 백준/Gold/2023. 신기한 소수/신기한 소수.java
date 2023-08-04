import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		find(0, N);
		
		System.out.println(sb);
	}
	
	public static void find(int num, int n) {
		if(n == 0) {
			if(isPrime(num)) sb.append(num).append('\n');
			return;
		}
		
		for(int i=0; i<10; i++) {
			int next = num*10+i;
			if(isPrime(next)) find(next, n-1);
		}
	}
	
	public static boolean isPrime(int num) {
		if(num < 2) return false;
		
		for(int i=2; i*i <= num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}