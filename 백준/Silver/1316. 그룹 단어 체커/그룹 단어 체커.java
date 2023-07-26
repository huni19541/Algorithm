import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String str = "";
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			HashMap<Character, Integer> map = new HashMap<>();
			str = sc.nextLine();
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
