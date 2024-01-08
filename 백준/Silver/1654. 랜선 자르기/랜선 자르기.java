import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        long start = 1;
        long end = max;
        long answer = 0;
        while(start <= end) {
            long mid = (start + end) / 2;

            long temp = 0;
            for(int i=0; i<K; i++) {
                temp += (arr[i] / mid);
            }

            if(temp < N) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
                answer = mid;
            }
        }

        sb.append(answer);
        System.out.println(answer);
    }
}