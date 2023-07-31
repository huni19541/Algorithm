import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("Test.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int num = 0;
		for(int i=0; i<N; i++) {
			num = sc.nextInt();
			pq.add(num);
		}
		
		int[] sumArr = new int[N];
		int totalSum = 0;
		for(int i=0; i<N; i++) {
			if(i==0) {
				sumArr[i] = pq.poll();
				totalSum += sumArr[i];
				continue;
			}
			sumArr[i] = sumArr[i-1] + pq.poll();
			totalSum += sumArr[i];
		}
		
		System.out.println(totalSum);
	}

}
