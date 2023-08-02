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
		
		for(int i=1; i<=9; i++) {
			sb.append(A).append(" * ").append(i).append(" = ").append(A*i).append('\n');
		}
		
		System.out.println(sb);
	}

}