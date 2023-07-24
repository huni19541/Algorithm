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
	
	static int count(int[] arr, int M)
	{
		int cnt = 0;
		for(int i=0; i<arr.length; i++)
		{
			int sum = 0;
			for(int j=i; j<arr.length; j++)
			{
				sum += arr[j];
				if(sum >= M) break;
			}
			if(sum == M) cnt++;
		}
		return cnt;
	}
}
