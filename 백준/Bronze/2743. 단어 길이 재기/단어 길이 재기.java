import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static int[] arr;
	static int arrIdx = 0;
	static boolean[] check;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
//		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		sb.append(str.length());
		
		System.out.println(sb);
	}

}