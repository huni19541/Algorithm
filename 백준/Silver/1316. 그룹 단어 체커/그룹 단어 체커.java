import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = "";
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			HashMap<Character, Integer> map = new HashMap<>();
			str = br.readLine();
			boolean check = true;
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				
				if(map.containsKey(c)) {
					if(str.charAt(j-1) != c) {
						check = false;
						break;
					}
				}
				else {
					map.put(c, 1);
				}
			}
			if(check) cnt++;
		}
		
		System.out.println(cnt);

	}

}
