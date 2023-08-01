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
		int res = 0;
//		int B = Integer.parseInt(st.nextToken());
		
		if((A % 4 == 0 && A % 100 != 0) || A % 400 == 0)
			res = 1;
		
		sb.append(res);
		
		System.out.println(sb);
	}

}