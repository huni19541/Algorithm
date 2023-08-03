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
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		String temp = "";
		String temp2 = "";
		for(int i=str1.length()-1; i>=0; i--) {
			temp += str1.charAt(i);
		}
		for(int i=str2.length()-1; i>=0; i--) {
			temp2 += str2.charAt(i);
		}
		
		int res = Integer.parseInt(temp) > Integer.parseInt(temp2) ? Integer.parseInt(temp) : Integer.parseInt(temp2);
		sb.append(res);
		
		System.out.println(sb);
	}
}