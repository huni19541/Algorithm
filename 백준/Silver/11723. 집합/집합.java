import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			
			if(str.equals("all")) {
				list.clear();
				for(int j=1; j<=20; j++) {
					list.add(j);
				}
			}
			else if(str.equals("empty")) {
				list.clear();
			}
			else {
				int x = Integer.parseInt(str.split(" ")[1]);
				
				if(str.startsWith("add")) {
					if(!list.contains(x))
						list.add(x);
				}
				else if(str.startsWith("check")) {
					if(list.contains(x))
						sb.append("1\n");
					else
						sb.append("0\n");
				}
				else if(str.startsWith("toggle")){
					if(!list.contains(x))
						list.add(x);
					else {
						for(int j=0; j<list.size(); j++) {
							if(x == list.get(j)) {
								list.remove(j);
								break;
							}
						}
					}
				}
				else if(str.startsWith("remove")) {
					for(int j=0; j<list.size(); j++) {
						if(x == list.get(j)) {
							list.remove(j);
							break;
						}
					}
				}
			}
		}
		
		System.out.println(sb);
	}

}