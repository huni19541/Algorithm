import java.util.Stack;

public class Solution {
    public int[] solution(int[] arr) {
		int[] answer;
		
		Stack<Integer> s = new Stack<>();
		
		for(int i=0; i<arr.length; i++) {
			if(s.isEmpty())
				s.push(arr[i]);
			
			if(s.peek() != arr[i])
				s.push(arr[i]);
		}
		
		answer = new int[s.size()];
		for(int i=0; i<answer.length; i++)
			answer[answer.length-1-i] = s.pop();		
		
		return answer;
	}
}