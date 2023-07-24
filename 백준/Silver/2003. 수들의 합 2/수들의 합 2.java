import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
		
		int N, M;
		int[] A;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		A = new int[N];
		for(int i=0; i<N; i++)
			A[i] = sc.nextInt();
		
		int res = count(A, M);
		System.out.println(res);
	}

	// 누적합 계산
	static int count(int[] arr, int M)
	{
		int cnt = 0;
		for(int i=0; i<arr.length; i++)
		{
			int sum = 0;
			// i부터 누적합이 M 넘으면 break;
			for(int j=i; j<arr.length; j++)
			{
				sum += arr[j];
				if(sum >= M) break;
			}
			// 누적합이 M 이면 cnt++
			if(sum == M) cnt++;
		}
		return cnt;
	}
}
