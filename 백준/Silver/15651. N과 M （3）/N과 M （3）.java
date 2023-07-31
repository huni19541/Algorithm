import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N = 0;
	static int M = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		iter(N, M);
		System.out.println(sb);

	}

	// M개 만큼 재귀
	public static void iter(int N, int M) {
		
		if(M == 0) {
			for(Integer i : list) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
			return;
		}

		// ArrayList를 이용하여 값 저장
		for(int i=1; i<=N; i++) {
			list.add(i);
			iter(N, M-1);
			// 다음 반복에는 마지막에 저장된 값 제거
			list.remove(list.size()-1);
		}
	}

}
