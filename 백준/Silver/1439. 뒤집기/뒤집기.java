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
	
		String str = br.readLine();
		int zeroCnt = 0, oneCnt = 0;
		
		
		char cur = str.charAt(0);
		for(int i=1; i<str.length(); i++) {
			if(cur != str.charAt(i)) {
				if(cur == '0') zeroCnt++;
				else oneCnt++;
				cur = str.charAt(i);
			}
		}
		if(cur == '0') zeroCnt++;
		else oneCnt++;
		
		int res = zeroCnt <= oneCnt ? zeroCnt : oneCnt;
		sb.append(res);
		
		System.out.println(sb);
	}

}