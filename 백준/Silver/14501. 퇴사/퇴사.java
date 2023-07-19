import java.util.Scanner;

public class Main {

	// 변수 선언
	static int N;
	static int[] T;
	static int[] P;
	static boolean[] visit;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		T = new int[N];
		P = new int[N];
		visit = new boolean[N];

		// 입력
		for(int i=0; i<N; i++)
		{
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		iter(0);
		System.out.println(max);
		
		
		sc.close();
	}

	// 재귀함수 이용
	static void iter(int idx)
	{
		// 재귀함수 리턴 조건
		if(idx >= N)
		{
			calc();
			return;
		}

		// 해당하는 index 값 -> true/false 활용하여 계산
		for(int i=idx; i<N; i++)
		{
			if(i+T[i] <= N)
				visit[i] = true;
			iter(i+T[i]);
			visit[i] = false;
		}
	}

	// true만 계산
	static void calc()
	{
		int sum = 0;
		for(int i=0; i<N; i++)
		{
			if(visit[i] == true)
				sum += P[i];
		}
		
		max = max < sum ? sum : max;
	}
}
