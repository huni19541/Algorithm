class Solution {
    static int[] nums;
	static boolean[] visit;
	static int cnt = 0;
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        nums = numbers;
        visit = new boolean[nums.length];
        
        for(int i=0; i<nums.length; i++) {
        	iter(0, i, target);
        }
        
        answer = cnt;
        return answer;
    }
	
	public static void iter(int idx, int minusCnt, int target) {
		if(minusCnt == 0) {
			int sum = 0;
			for(int i=0; i<nums.length; i++) {
				if(visit[i]) {
					sum -= nums[i];
				}
				else {
					sum += nums[i];
				}
			}
			if(sum == target) cnt++;
		}
		
		for(int i=idx; i<nums.length; i++) {
			visit[i] = true;
			iter(i+1, minusCnt-1, target);
			visit[i] = false;
		}
	}
}