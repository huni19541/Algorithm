import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		boolean asc = true, des = true;
		
		int prevNum = 0;
		for(int i=0; i<8; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(!(num == i+1 || num == 8-i)) {
				asc = false;
				des = false;
				break;
			}
			
			if(i == 0) {
				if(num == 1) des = false;
				else if(num == 8) asc = false;
				prevNum = num;
				continue;
			}
			
			if(asc) {
				if(!(num == prevNum+1)) {
					asc = false;
					break;
				}
			}
			
			if(des) {
				if(!(num == prevNum-1)) {
					des = false;
					break;
				}
			}
			prevNum = num;
		}
		if(asc) sb.append("ascending");
		else if(des) sb.append("descending");
		else if(!asc && !des) sb.append("mixed");
		
		
		System.out.println(sb);
	}

}