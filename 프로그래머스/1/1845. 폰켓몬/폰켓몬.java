import java.io.*;
import java.util.*;

class Solution{
    
    public int solution(int[] nums) {
        int res;
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0)+1);
        }
        if(hashmap.size() >= (nums.length/2)) {
            res = nums.length/2;
        } else {
            res = hashmap.size();
        }
        
		return res;
    }
}