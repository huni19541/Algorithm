import java.io.*;
import java.util.*;

public class Main {
	
	static String T, P;
	static int[] pi;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = br.readLine();
		P = br.readLine();
		pi = new int[P.length()];
		list = new ArrayList<>();
		
		fillPI();
		KMP();
		sb.append(list.size()).append('\n');
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb);
	}
	
	private static void fillPI() {
		int j = 0;
		for(int i=1; i<P.length(); i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j)) {
				j = pi[j-1];
			}
			
			if(P.charAt(i) == P.charAt(j)) {
				j++;
			}
			pi[i] = j;
		}
	}
	
	private static void KMP() {
		int j = 0;
		for(int i=0; i<T.length(); i++) {
			while(j > 0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j-1];
			}
			
			if(T.charAt(i) == P.charAt(j)) {
				if(j == P.length()-1) {
					list.add(i-j+1);
					j = pi[j];
				} else {
					j++;
				}
			}
			
			
		}
	}

}