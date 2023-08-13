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
import java.util.NoSuchElementException;
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
		
		String str = br.readLine();
		String[] nums = str.split("\\-");
		
		int[] intNums = new int[nums.length];
		
		int idx = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i].contains("+")) {
				String[] temp = nums[i].split("\\+");
				for(int j=0; j<temp.length; j++)
					intNums[idx] += Integer.parseInt(temp[j]);
				idx++;
			}
			else {
				intNums[idx++] = Integer.parseInt(nums[i]);
			}
		}
		
		int sum = intNums[0];
		for(int i=1; i<idx; i++) {
			sum -= intNums[i];
		}
		
		sb.append(sum);
		
		System.out.println(sb);
	}

}