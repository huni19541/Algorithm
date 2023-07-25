import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer;
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<progresses.length; i++) {
			int num = progresses[i];
			int cnt = 0;
			
			while(num < 100) {
				num += speeds[i];
				cnt++;
			}
			queue.add(cnt);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		while(queue.size() != 0) {
			
			int dayCnt = 1;
			int peek = queue.poll();
			if(queue.size() == 0) {
				list.add(dayCnt);
				break;
			}
			
			while(queue.size() != 0 && queue.peek() <= peek) {
				queue.remove();
				dayCnt++;
			}
			
			list.add(dayCnt);
			
		}
		
		answer = new int[list.size()];
		for(int i=0; i<answer.length; i++)
			answer[i] = list.get(i);
		
		return answer;
	}
    
    public static int[] solution2(int[] progresses, int[] speeds) {
		int[] answer = {};
        
        	// 값이 저장될 가변배열
		ArrayList<Integer> al = new ArrayList<>();
        
		int idx = 0;
		while(true)
		{
            		// 매일 진도율 더하기
			for(int i=0; i<speeds.length; i++)
			{
				progresses[i] += speeds[i];
				if(progresses[i] > 100) progresses[i] = 100;
			}
			
			int cnt = 0;
			
            		// 작업이 완성된 개수 구하기
			while(progresses[idx] == 100)
			{
				cnt++;
				idx++;
				if(idx == speeds.length)
					break;
			}
			
            		// 작업이 완성된 개수 추가
			if(cnt != 0)
				al.add(cnt);
			
            		// 모든 작업 완성
			if(idx == speeds.length)
				break;
		}
		
       		// int[] 배열 선언
		answer = new int[al.size()];
		
        	// ArrayList값 옮기기
		for(int i=0; i<al.size(); i++)
			answer[i] = al.get(i);
		
        return answer;
    }
}