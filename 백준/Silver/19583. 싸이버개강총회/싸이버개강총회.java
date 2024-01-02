import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		String start = st.nextToken();
		String end = st.nextToken();
		String streamingEnd = st.nextToken();
		
		HashSet<String> set1 = new HashSet<>();
		HashSet<String> set2 = new HashSet<>();
		
		String input;
		while((input = br.readLine()) != null) {
			String time = input.split(" ")[0];
			String nickname = input.split(" ")[1];
			
			if(timeCheck("00:00", start, time)) {
				set1.add(nickname);
			}
			
			if(timeCheck(end, streamingEnd, time)) {
				if(set1.contains(nickname)) {
					set2.add(nickname);
				}
			}
		}
		
		sb.append(set2.size());
		System.out.println(sb);
	}
	
	public static boolean timeCheck(String time1, String time2, String target) {
		
		int H1 = Integer.parseInt(time1.substring(0, 2));
		int M1 = Integer.parseInt(time1.substring(3, 5));
		
		int H2 = Integer.parseInt(time2.substring(0, 2));
		int M2 = Integer.parseInt(time2.substring(3, 5));
		
		int H = Integer.parseInt(target.substring(0, 2));
		int M = Integer.parseInt(target.substring(3, 5));
		
		if(H >= H1 && H <= H2) {
			if(H == H1 && H == H2) {
				if(M >= M1 && M <= M2) {
					return true;
				}
			}
			else if(H == H1) {
				if(M >= M1) {
					return true;
				}
			}
			else if(H == H2) {
				if(M <= M2) {
					return true;
				}
			}
			else {
				return true;
			}
		}
		
		return false;
	}

}