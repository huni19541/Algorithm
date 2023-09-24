import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	int H = Integer.parseInt(st.nextToken());
    	int W = Integer.parseInt(st.nextToken());
    	int X = Integer.parseInt(st.nextToken());
    	int Y = Integer.parseInt(st.nextToken());
    	    	
    	int[][] map = new int[H+X][W+Y];
    	for(int i=0; i<H+X; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<W+Y; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int[][] ans = new int[H][W];
    	for(int i=0; i<H; i++) {
    		for(int j=0; j<W; j++) {
    			if(i < X || j < Y) {
    				ans[i][j] = map[i][j];
    			} else if (i > H-X-1 && j > Y-1) {
    				ans[i][j] = map[i+X][j+Y];
    			} else {
    				ans[i][j] = map[i][j] - ans[i-X][j-Y];
    			}
    		}
    	}
    	
    	for(int i=0; i<H; i++) {
    		for(int j=0; j<W; j++) {
    			sb.append(ans[i][j]).append(" ");
    		}
    		sb.append('\n');
    	}
    	
    	
    	System.out.println(sb);
    }
}