class Solution {
    public int[] solution(int brown, int yellow){
        int[] answer = {};
        int total = brown + yellow;
        
        int width = 0, height = 0;
        for(int i=3; i<=total/3; i++)
        {
            if(total%i == 0)
            {
                width = total/i;
                height = total/width;
                
                if((width-2)*(height-2) == yellow)
                    break;
            }
        }
        answer = new int[]{width, height};
        
        return answer;
    }
}