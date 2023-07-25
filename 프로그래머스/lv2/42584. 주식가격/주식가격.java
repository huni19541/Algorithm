import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int[] solution(int[] prices) {
        int[] answer = {};
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<prices.length; i++) {
        	queue.add(prices[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(queue.size() != 0) {
        	int now = queue.poll();
        	int cnt = 0;
        	
        	for(Integer i : queue) {
        		cnt++;
        		if(i < now) {
        			break;
        		}
        	}
        	list.add(cnt);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}