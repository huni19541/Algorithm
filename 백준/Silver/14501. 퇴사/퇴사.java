import java.util.Scanner;

public class Main {
	
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
		
		for(int i=0; i<N; i++)
		{
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		iter(0);
		System.out.println(max);
		
		
		sc.close();
	}

	static void iter(int idx)
	{
		if(idx >= N)
		{
			calc();
			return;
		}
		
		for(int i=idx; i<N; i++)
		{
			if(i+T[i] <= N)
				visit[i] = true;
			iter(i+T[i]);
			visit[i] = false;
		}
	}
	
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