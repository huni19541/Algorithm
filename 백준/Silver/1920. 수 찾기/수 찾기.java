import java.util.HashMap;
import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {

		int N, M, num;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=0; i<N; i++)
		{
			num = sc.nextInt();
			map.put(num, map.getOrDefault(num, 1)+1);
		}
		
		M = sc.nextInt();
		for(int i=0; i<M; i++)
		{
			num = sc.nextInt();
			
			if(map.containsKey(num))
				System.out.println(1);
			else
				System.out.println(0);
		}
		
		sc.close();
	}
}
