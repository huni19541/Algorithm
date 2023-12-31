public class Solution {
	    public int solution(int[][] triangle) {
	        int answer = 0;
		
	        int tl = triangle.length;

		// 재사용 할 dp배열 선언
	        int dp[][] = new int[tl][];
	        dp[0] = triangle[0];
	        
	        for(int i=1; i<tl; i++)
	        {
	            dp[i] = new int[i+1];

		    // 왼쪽과 오른쪽 중 최대값 더하기
	            for(int j=0; j<i+1; j++)
	            {
	                if(j==0)
	                    dp[i][j] = dp[i-1][j] + triangle[i][j];
	                
	                else if(j==i)
	                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
	                
	                else
	                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
	            }
	        }
            
	        int dl = dp.length-1;
	        int dll = dp[dl].length;
            
            	int max = -9;

		// dp에 저장된 값 중 최대값 구하기
	        for(int i=0; i<dll; i++)
	            max = max < dp[dl][i] ? dp[dl][i] : max;
	        
            	answer = max;
            
	        return answer;
	    }
}
