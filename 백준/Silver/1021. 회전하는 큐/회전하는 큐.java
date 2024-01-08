import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=N; i++) {
            deque.offer(i);
        }

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());

            Deque<Integer> dequeLeft = new ArrayDeque<>(deque);
            Deque<Integer> dequeRight = new ArrayDeque<>(deque);

            int cntLeft = 0, cntRight = 0;
            while(dequeLeft.peek() != num) {
                int n = dequeLeft.pollLast();
                dequeLeft.offerFirst(n);
                cntLeft++;
            }
            while(dequeRight.peek() != num) {
                int n = dequeRight.pollFirst();
                dequeRight.offerLast(n);
                cntRight++;
            }

            if(cntLeft >= cntRight) {
                deque = dequeRight;
                answer += cntRight;
            } else {
                deque = dequeLeft;
                answer += cntLeft;
            }

            deque.pollFirst();
        }

        sb.append(answer);
        System.out.println(answer);
    }
}