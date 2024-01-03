import java.util.*;
import java.io.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        boolean[] visited = new boolean[100001];
        int[] arr = new int[100001];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{2, 1});
        visited[2] = true;
        arr[2] = 1;
        queue.offer(new int[]{5, 1});
        visited[5] = true;
        arr[5] = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            arr[cur[0]] = cur[1];

            if(cur[0]+2 <= 100000 && !visited[cur[0]+2]) {
                visited[cur[0]+2] = true;
                queue.offer(new int[]{cur[0]+2, cur[1]+1});
            }

            if(cur[0]+5 <= 100000 && !visited[cur[0]+5]) {
                visited[cur[0]+5] = true;
                queue.offer(new int[]{cur[0]+5, cur[1]+1});
            }
        }

        int n = Integer.parseInt(br.readLine());
        if(arr[n] != 0) {
            sb.append(arr[n]);
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }
}