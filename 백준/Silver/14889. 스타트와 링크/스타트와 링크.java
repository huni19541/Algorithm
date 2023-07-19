import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] S;
	static boolean[] visit; 
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		S = new int[N][N];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				S[i][j] = sc.nextInt();
		
		iter(0, 0);
		System.out.println(min);
		
	}
	
	static void iter(int idx, int count)
	{
		if(count == N/2)
		{
			int res = calc();
			min = min > res ? res : min;
			if(min == 0)
			{
				System.out.println(min);
				System.exit(0);
			}
			return;
		}
		
		for(int i=idx; i<N; i++)
		{
			visit[i] = true;
			iter(i+1, count+1);
			visit[i] = false;
		}
	}
	
	static int calc()
	{
		int start = 0, link = 0;
		
		for(int i=0; i<N-1; i++)
		{
			for(int j=i+1; j<N; j++)
			{
				if(visit[i] == true && visit[j] == true)
				{
					start += S[i][j];
					start += S[j][i];
				}
				
				if(visit[i] == false && visit[j] == false)
				{
					link += S[i][j];
					link += S[j][i];
				}
			}
		}
		
		
		int res = Math.abs(Math.subtractExact(start, link));
		return res;
	}

}
