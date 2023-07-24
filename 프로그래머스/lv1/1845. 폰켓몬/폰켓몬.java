import java.util.HashMap;

class Solution{
    
    public int solution(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
		
		int cnt = nums.length / 2;
		
		for(int n : nums)
			hm.put(n, hm.getOrDefault(n, 0)+1);
		
		int res = hm.size() > cnt ? cnt : hm.size();
		return res;
    }
}