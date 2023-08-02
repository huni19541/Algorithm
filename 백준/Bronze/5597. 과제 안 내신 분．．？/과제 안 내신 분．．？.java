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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		boolean[] check = new boolean[31];
		for(int i=0; i<28; i++) {
			check[Integer.parseInt(br.readLine())] = true;
		}
		
		for(int i=1; i<=30; i++) {
			if(!check[i]) sb.append(i).append('\n');
		}
		
		System.out.println(sb);
	}

}