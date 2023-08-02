import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	static int res = 0;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		boolean[] check = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		iter(nums, check, 0, 0);
		
		sb.append(res);
		
		System.out.println(sb);
		
	}
	
	static void iter(int[] nums, boolean[] check, int idx, int cnt) {
		if(cnt == 3) {
			int sum = 0;
			for(int i=0; i<nums.length; i++) {
				if(check[i]) sum += nums[i];
			}
			if(sum <= M && sum > res) {
				res = sum;
			}
			
			return;
		}
		
		for(int i=idx; i<nums.length; i++) {
			if(!check[i]) {
				check[i] = true;
				iter(nums, check, i+1, cnt+1);
				check[i] = false;
			}
		}
	}
	
	
}