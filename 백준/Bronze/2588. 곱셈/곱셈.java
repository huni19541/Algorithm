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
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(br.readLine());
//		int B = Integer.parseInt(br.readLine());
		String B = br.readLine();
		
		for(int i=2; i>=0; i--)
			sb.append(A*Character.getNumericValue(B.charAt(i))).append('\n');
		
		sb.append(A*Integer.parseInt(B)).append('\n');
		System.out.println(sb);
	}

}