import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[][] pos = new int[3][2];
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int x = pos[0][0]^pos[1][0]^pos[2][0];
		int y = pos[0][1]^pos[1][1]^pos[2][1];
		
		sb.append(x).append(" ").append(y);
		System.out.println(sb);
	}

}