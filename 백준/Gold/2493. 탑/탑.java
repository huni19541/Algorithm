import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] resArr = new int[N+1];
		int idx = N-1;
		
		String[] nums = br.readLine().split(" ");
		
		Stack<int[]> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			
			int[] num = new int[] {Integer.parseInt(nums[N-1-i]), N-i};
			
			if(stack.isEmpty()) {
				stack.push(num);
				continue;
			}
			
			while(stack.peek()[0] < num[0]) {
				resArr[stack.pop()[1]] = N-i;
				if(stack.isEmpty()) break;
			}
			
			stack.push(num);
		}
		
		while(!stack.isEmpty())
		{
			resArr[stack.pop()[1]] = 0;
		}

		for(int i=1; i<=N; i++)
			sb.append(resArr[i]).append(" ");
		
		System.out.println(sb);
	}

}