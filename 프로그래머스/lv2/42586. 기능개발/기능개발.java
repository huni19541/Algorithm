import java.util.ArrayList;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
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
