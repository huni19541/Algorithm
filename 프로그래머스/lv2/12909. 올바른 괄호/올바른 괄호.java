import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        char c;
        
        for(int i=0; i<s.length(); i++)
        {
            c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            else
            {
                if(stack.empty())
                {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        if(!stack.empty())
            answer = false;

        return answer;
    }
}