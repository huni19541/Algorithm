import java.io.*;
import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // y: r2
        answer++;
        
        // y: r1 ~ r2-1
        for(int i=r2-1; i>=r1; i--) {
            answer += (Math.floor(getX(i, r2)) * 2);
            answer++;
        }
        
        // y: 1 ~ r1-1
        for(int i=r1-1; i>0; i--) {
            answer += 
                ((((int)Math.floor(getX(i, r2)) 
                  - (int)Math.ceil(getX(i, r1))) + 1) * 2);
        }
        // 위 아래 대칭
        answer *= 2;
        
        // y: 0
        answer += ((((int)Math.floor(getX(0, r2)) 
                  - (int)Math.ceil(getX(0, r1))) + 1) * 2);
        
        
        return answer;
    }
    
    static double getX(int y, int r) {
        double x =  (Math.sqrt((Math.pow(r, 2) - Math.pow(y, 2))));
        return x;
    }
}