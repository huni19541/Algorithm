import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville)
        	pq.add(i);
        
        while(pq.peek() < K)
        {
            if(pq.size() == 1)
        		return -1;
        	int n1 = pq.poll();
        	int n2 = pq.poll();
        	
        	pq.add(n1+n2*2);
        	answer++;
        }
        
        return answer;
    }
}