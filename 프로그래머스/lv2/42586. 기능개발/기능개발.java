import java.util.ArrayList;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		ArrayList<Integer> al = new ArrayList<>();
        
		int idx = 0;
		while(true)
		{
			for(int i=0; i<speeds.length; i++)
			{
				progresses[i] += speeds[i];
				if(progresses[i] > 100) progresses[i] = 100;
			}
			
			int cnt = 0;
			
			while(progresses[idx] == 100)
			{
				cnt++;
				idx++;
				if(idx == speeds.length)
					break;
			}
			
			if(cnt != 0)
				al.add(cnt);
			
			if(idx == speeds.length)
				break;
		}
		
		answer = new int[al.size()];
		
		for(int i=0; i<al.size(); i++)
			answer[i] = al.get(i);
		
        return answer;
    }
}