import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[3];
			for(int i=0; i<3; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
				break;
			
			Arrays.sort(arr);
			
			if((int)(Math.pow(arr[2], 2)) == ((int)(Math.pow(arr[0], 2)) + (int)(Math.pow(arr[1], 2))))
				sb.append("right\n");
			else
				sb.append("wrong\n");
		}
		
		
		System.out.println(sb);
	}

}