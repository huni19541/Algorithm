import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static class OS{
		int priority;
		int idx;
		
		public OS(int priority, int idx) {
			this.priority = priority;
			this.idx = idx;
		}
	}
	
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		
		Queue<OS> queue = new LinkedList<>();
		for(int i=0; i<priorities.length; i++)
			queue.add(new OS(priorities[i], i));
		
		int cnt = 0;
		while(queue.size() != 0) {
			int max = -1;
			for(OS os : queue) {
				max = os.priority > max ? os.priority : max;
			}
			
			OS os = queue.poll();
			if(os.priority == max) {
				cnt++;
				if(os.idx == location) {
					answer = cnt;
					break;
				}
			} else {
				queue.add(os);
			}
		}
		
		return answer;
	}
}