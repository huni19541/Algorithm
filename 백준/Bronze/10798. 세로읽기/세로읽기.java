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
		
		char[][] map = new char[5][15]; 
		int[] len = new int[5];
		
		int maxLen = Integer.MIN_VALUE;
		for(int i=0; i<5; i++) {
			String str = br.readLine();
			len[i] = str.length();
			maxLen = maxLen < len[i] ? len[i] : maxLen;
			
			for(int j=0; j<len[i]; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<maxLen; i++) {
			for(int j=0; j<5; j++) {
				if(i >= len[j]) continue;
				
				sb.append(map[j][i]);
			}
		}
		
		
		
		System.out.println(sb);
	}
	
}