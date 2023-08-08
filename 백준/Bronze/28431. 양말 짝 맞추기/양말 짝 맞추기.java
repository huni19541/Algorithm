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
		
//		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[10];
		for(int i=0; i<5; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[num]++;
			if(nums[num] > 2) nums[num] -= 2; 
		}
		
		for(int i=0; i<10; i++) {
			if(nums[i] == 1) {
				sb.append(i);
				break;
			}
		}
		
				
		System.out.println(sb);
	}

}