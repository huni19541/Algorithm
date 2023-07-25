import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

class Solution {
    	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer;

	    	// 넣는 순서대로 값을 추출하기 위한 Queue
		Queue<Integer> queue = new LinkedList<>();

	    	// 100이 될 때 까지 남은 day를 count해서 queue에 추가
		for(int i=0; i<progresses.length; i++) {
			int num = progresses[i];
			int cnt = 0;
			
			while(num < 100) {
				num += speeds[i];
				cnt++;
			}
			queue.add(cnt);
		}

	    	// 100이 넘는 day만 넣기 위한 가변배열
		ArrayList<Integer> list = new ArrayList<>();

	    	// 값 빼내기
		while(queue.size() != 0) {

			// 원래 1개만 있었던 경우
			int dayCnt = 1;
			int peek = queue.poll();
			if(queue.size() == 0) {
				list.add(dayCnt);
				break;
			}

			// 처음 남은 day보다 더 많은 day가 남은 것 전까지 가변배열에 추가
			while(queue.size() != 0 && queue.peek() <= peek) {
				queue.remove();
				dayCnt++;
			}
			
			list.add(dayCnt);
			
		}

	    	// ArrayList<Integer> -> int[]
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
