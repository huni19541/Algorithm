import java.io.*;
import java.util.*;

public class Main {
	
	static class Info{
		int age;
		String name;
		int idx;
		
		Info(int age, String name, int idx){
			this.age = age;
			this.name = name;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Info[] arr = new Info[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Info(Integer.parseInt(st.nextToken()), st.nextToken(), i);
		}
		
		Arrays.sort(arr, (o1, o2) -> (o1.age == o2.age) ? o1.idx - o2.idx : o1.age - o2.age);
		
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i].age).append(" ").append(arr[i].name).append('\n');
		}
		
		System.out.println(sb);
	}

}