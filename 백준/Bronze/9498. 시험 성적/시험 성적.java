import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(br.readLine());
//		int B = Integer.parseInt(st.nextToken());
		
		if(A >= 90) sb.append('A');
		else if(A >= 80) sb.append('B');
		else if(A >= 70) sb.append('C');
		else if(A >= 60) sb.append('D');
		else sb.append('F');
		
		System.out.println(sb);
	}

}