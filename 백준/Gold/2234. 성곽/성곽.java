import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] info;
	static int[][] map;
	static boolean[][] visited;
	static int roomNum = 1;
	static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dc = {1, 0, -1, 0};
	static int roomCnt = 0;
	static int maxRoomCnt = Integer.MIN_VALUE;
	static int[] roomCntArr;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	info = new int[M][N];
    	map = new int[M][N];
    	visited = new boolean[M][N];
    	
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<N; j++) {
    			info[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	ArrayList<Integer> temp = new ArrayList<>();
    	for(int i=0; i<M; i++) {
    		for(int j=0; j<N; j++) {
    			if(!visited[i][j]) {
    				roomCnt = 1;
    				map[i][j] = roomNum;
    				visited[i][j] = true;
    				
        			find(i, j);
        			
        			temp.add(roomCnt);
        			roomNum++;
        			maxRoomCnt = Math.max(maxRoomCnt, roomCnt);
    			}
    		}
    	}
    	roomCntArr = new int[roomNum];
    	for(int i=1; i<roomNum; i++) {
    		roomCntArr[i] = temp.get(i-1);
    	}
    	
    	ArrayList<Integer>[] adjList = new ArrayList[roomNum];
    	for(int i=1; i<roomNum; i++) {
    		adjList[i] = new ArrayList<>();
    	}
    	
    	boolean[][] check = new boolean[roomNum][roomNum];
    	for(int i=0; i<M; i++) {
    		for(int j=0; j<N; j++) {
    			int curRoom = map[i][j];
    			
    			for(int k=0; k<4; k++) {
    				int nr = i + dr[k];
    				int nc = j + dc[k];
    				
    				if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
    				
    				if(map[nr][nc] != curRoom) {
    					if(!check[curRoom][map[nr][nc]] && !check[map[nr][nc]][curRoom]) {
    						check[curRoom][map[nr][nc]] = true;
    						check[map[nr][nc]][curRoom] = true;
        					adjList[curRoom].add(map[nr][nc]);
        					adjList[map[nr][nc]].add(curRoom);
    					}
    				}
    			}
    		}
    	}
    	
    	int largestRoom = Integer.MIN_VALUE;
    	for(int i=1; i<roomNum; i++) {
    		
    		int sum = roomCntArr[i];
    		for(int j=0; j<adjList[i].size(); j++) {
    			sum += roomCntArr[adjList[i].get(j)];
    			largestRoom = Math.max(largestRoom, sum);
    			sum -= roomCntArr[adjList[i].get(j)];
    		}
    	}
    	
    	
    	
    	sb.append(roomNum-1).append('\n').
    	append(maxRoomCnt).append('\n')
    	.append(largestRoom);
    	
    	System.out.println(sb);
    }
    
    private static void find(int curr, int curc) {
    	
    	for(int i=0; i<4; i++) {
    		int nr = curr + dr[i];
    		int nc = curc + dc[i];
    		
    		if(nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc]) continue;
    		
    		if((info[nr][nc]&(1<<i)) == (1<<i)) {
//    			System.out.println(info[nr][nc] + " " + (1<<i));
    			continue;
    		}
    		
    		visited[nr][nc] = true;
    		map[nr][nc] = roomNum;
    		roomCnt++;
    		find(nr, nc);
    	}
    }
}