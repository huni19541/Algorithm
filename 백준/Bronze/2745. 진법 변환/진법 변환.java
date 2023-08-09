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
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int num = Integer.parseInt(st.nextToken());
		
		int idx = str.length()-1;
		int pending = 0;
		int sum = 0;
		while(idx >= 0) {
			char c = str.charAt(idx--);
			int subSum = (int)Math.pow(num,  pending++);
			if(Character.isDigit(c))
				sum += subSum*Character.getNumericValue(c);
			else
				sum += subSum*(c-55);
		}
		
		sb.append(sum);
		
		System.out.println(sb);
	}

}