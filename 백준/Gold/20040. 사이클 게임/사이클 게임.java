import java.io.*;
import java.util.*;

public class Main {

    static int[] parents = new int[500000];
    static boolean flag = true;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        make();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!flag) {
                continue;
            }

            if(!union(a, b)) {
                sb.append(i+1);
            }
        }
        if(flag) {
            sb.append(0);
        }
        System.out.println(sb);
    }

    public static void make() {
        for(int i=0; i<500000; i++) {
            parents[i] = i;
        }
    }

    public static int find(int a) {
        if(a == parents[a]) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) {
            flag = false;
            return false;
        }

        parents[bRoot] = aRoot;
        return true;
    }
}