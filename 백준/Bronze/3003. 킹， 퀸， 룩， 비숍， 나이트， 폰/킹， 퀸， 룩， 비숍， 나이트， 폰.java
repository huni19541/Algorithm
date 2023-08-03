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

		int[] correct = {1, 1, 2, 2, 2, 8};
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[6];
		for(int i=0; i<6; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = (correct[i] - num);
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}