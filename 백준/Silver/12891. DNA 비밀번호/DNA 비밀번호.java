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
	
	static class DNA{
		static int size = 4;
		int[] num = new int[size];
		
		DNA(int[] nums){
			for(int i=0; i<size; i++) {
				num[i] = nums[i];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		DNA[] DNAs= new DNA[str.length()];
		
		int[] cnts = {0, 0, 0, 0};
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == 'A') {
				cnts[0]++;
				DNAs[i] = new DNA(cnts);
			}
			else if(c == 'C') {
				cnts[1]++;
				DNAs[i] = new DNA(cnts);
			}
			else if(c == 'G') {
				cnts[2]++;
				DNAs[i] = new DNA(cnts);
			}
			else {
				cnts[3]++;
				DNAs[i] = new DNA(cnts);
			}
		}
		
		int[] arr = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		int cnt = 0;
		int[] numOfAlpha = new int[4];
		while(idx <= (S-P)) {

			boolean check = true;
			for(int i=0; i<4; i++) {
				if(idx == 0) {
					numOfAlpha[i] = DNAs[idx+P-1].num[i];
				} else {
					numOfAlpha[i] = DNAs[idx+P-1].num[i] - DNAs[idx-1].num[i];
				}
				if(numOfAlpha[i] < arr[i]) {
					check = false;
					break;
				}
			}
			
			if(check) cnt++;
			
			idx++;
		}
		
		sb.append(cnt);
		
		System.out.println(sb);
		
	}
}