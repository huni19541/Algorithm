import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// Scanner 사용 시 BufferedReader 보다 메모리 4배, 시간 3배 증가 
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// StringBuilder 사용해서 출력문 만드는 것 -> 시간 단축
		StringBuilder sb = new StringBuilder();

		// PriorityQueue 정렬 방법을 람다식으로 재정의
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int res1 = Math.abs(o1.intValue());
			int res2 = Math.abs(o2.intValue());
			return ((res1 - res2) == 0) ? (o1.intValue() - o2.intValue()) : res1 - res2;
		});

//		int N = sc.nextInt();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
//			int x = sc.nextInt();
			int x = Integer.parseInt(br.readLine());

			// 입력이 0일 때
			if (x == 0) {
				// pr가 비어있으면 sb에 "0\n" 추가
				if (pq.isEmpty()) {
					sb.append(0).append('\n');
					continue;
				} 
				// pr에 값이 있으면 sb에 맨 위의 값 + '\n' 추가
				else {
					sb.append(pq.poll()).append('\n');
				}
			} 
			// 입력이 0이 아닐 때 pq에 값 추가
			else {
				pq.add(x);
			}
		}
		// sb 출력
		System.out.println(sb);
	}

}
