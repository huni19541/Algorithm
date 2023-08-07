import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_김동훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		// 기둥의 높이와 번호 저장
		int[][] nums = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = i;
		}
		
		// 결과 저장 배열
		int[] resArr = new int[N+1];
		
		Stack<int[]> stack = new Stack<>();
		stack.push(nums[N]);
		int[] num;
		for(int i=N-1; i>=1; i--) {
			// 현재 값과 기둥 번호
			num = nums[i];
			
			// 현재 기둥이 이전 기둥보다 크다면
			while(stack.peek()[0] < num[0]) {
				resArr[stack.pop()[1]] = i;
				if(stack.isEmpty()) break;
			}
			
			stack.push(num);
		}

		for(int i=1; i<=N; i++)
			sb.append(resArr[i]).append(" ");
		
		System.out.println(sb);
	}

}
