import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
		int answer = 0;
		
		int a = nums.length/2;

		HashMap<Integer, Integer> map = new HashMap<>();
		for(int n : nums)
			map.put(n, map.getOrDefault(n, 0) + 1);
		
		answer = map.size() > a ? a : map.size();
		
		return answer;
    }
}