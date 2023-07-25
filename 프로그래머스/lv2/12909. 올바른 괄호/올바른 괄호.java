import java.util.Stack;

class Solution {
    public static boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(')
				stack.push(c);
			
			else if(c == ')') {
				if(stack.isEmpty()) {
					answer = false;
					break;
				}
				
				if(stack.peek() == '(') {
					stack.pop();
				}
			}
		}
		
		if(!stack.isEmpty()) {
			answer = false;
		}
		
		return answer;
	}
}