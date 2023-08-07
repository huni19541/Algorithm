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
	
	static int k;
	static int[] nums;
	static boolean[] check;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String str;
		while(!(str = br.readLine()).equals("0")) {
			list = new ArrayList<>();
			st = new StringTokenizer(str);
			k = Integer.parseInt(st.nextToken());
			nums = new int[k];
			check = new boolean[k];
			for(int i=0; i<k; i++)
				nums[i] = Integer.parseInt(st.nextToken());
			
			select(k-1, k-6);
			Collections.sort(list, (o1, o2) -> {
				for(int i=0; i<o1.length; i++) {
					int num1 = o1[i];
					int num2 = o2[i];
					if(num1 != num2)
						return num1 - num2;
				}
				return 0;
			});
			
			for(int[] arr : list) {
				for(int i=0; i<arr.length; i++) {
					sb.append(arr[i]).append(" ");
				}
				sb.append('\n');
			}
			
			sb.append('\n');
		}
		
				
		System.out.println(sb);
	}
	
	static void select(int idx, int count) {
		if(count == 0) {
			int[] temp = new int[6];
			int index = 0;
			for(int i=0; i<k; i++) {
				if(!check[i]) {
					temp[index++] = nums[i];
				}
			}
			list.add(temp);
			return;
		}
		
		for(int i=idx; i>=0; i--) {
			if(!check[i]) {
				check[i] = true;
				select(i-1, count-1);
				check[i] = false;
			}
		}
	}

}