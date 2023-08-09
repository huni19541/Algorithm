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
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int difficulty = 0;
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int exclusiveCnt = (int)Math.round(N*0.15);
		int sum = 0;
		for(int i=exclusiveCnt; i<N-exclusiveCnt; i++)
			sum += arr[i];
		if(N != 0)
			difficulty = (int)Math.round((double)sum/(N-(exclusiveCnt*2)));
		
		sb.append(difficulty);
		System.out.println(sb);
	}

}