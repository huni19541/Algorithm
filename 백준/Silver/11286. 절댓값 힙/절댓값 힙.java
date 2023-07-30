import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int res1 = Math.abs(o1.intValue());
			int res2 = Math.abs(o2.intValue());
			return ((res1 - res2) == 0) ? (o1.intValue() - o2.intValue()) : res1 - res2;
		});

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append('\n');
					continue;
				} else {
					sb.append(pq.poll()).append('\n');
				}
			} else {
				pq.add(x);
			}
		}

		System.out.println(sb);
	}

}
