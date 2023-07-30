import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
				int res1 = Math.abs(o1.intValue());
				int res2 = Math.abs(o2.intValue());
				return ((res1 - res2) == 0) ? (o1.intValue() - o2.intValue()) : res1 - res2;
		}) ;
		
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			if(x == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
					continue;
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.add(x);
			}
		}
	}
	
}
