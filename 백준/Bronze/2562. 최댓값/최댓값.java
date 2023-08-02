import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = Integer.MIN_VALUE;
		int maxIdx = 0;
		
		int num;
		for(int i=0; i<9; i++) {
			num = Integer.parseInt(br.readLine());
			if(max < num) {
				max = num;
				maxIdx = i+1;
			}
		}
		
		sb.append(max).append('\n').append(maxIdx);
		System.out.println(sb);
	}

}