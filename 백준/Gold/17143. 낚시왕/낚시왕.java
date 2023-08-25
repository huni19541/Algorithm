import java.io.*;
import java.util.*;

public class Main {

	static int R, C, M;
	static int[][] map;
	static int[][] sharkIdx;
	static ArrayList<Shark> sharkList;
	static ArrayList<Integer> removeIdx;
	static int res;
	
	static class Shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharkList = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			sharkList.add(new Shark(r, c, s, d, z));
		}
		
		for(int i=1; i<=C; i++) {
			map = new int[R+1][C+1];
			sharkIdx = new int[R+1][C+1];
			removeIdx = new ArrayList<>();
			setMap(i-1);
			find(i);
			remove();
		}
		sb.append(res);
		System.out.println(res);
	}
	
	static void find(int c) {
		for(int i=1; i<=R; i++) {
			if(map[i][c] != 0) {
				res += map[i][c];
				removeIdx.add(sharkIdx[i][c]);
				break;
			}
		}
	}
	
	static void setMap(int time) {
		for(int i=0; i<sharkList.size(); i++) {
			Shark cur = sharkList.get(i);
			int curDir = cur.d;
			int move = 0, nr = 0, nc = 0;
			
			if(curDir == 1 && cur.r == 1) {
				curDir = 2;
			}
			else if(curDir == 2 && cur.r == R) {
				curDir = 1;
			}
			else if(curDir == 3 && cur.c == C) {
				curDir = 4;
			}
			else if(curDir == 4 && cur.c == 1) {
				curDir = 3;
			}
			
			// 위
			if(curDir == 1) {
				nc = cur.c;
				move = (time*cur.s) % (2*(R-1));
				
				if(move > ((cur.r - 1) + (R-1))) {
					nr = R - (move - ((cur.r - 1) + (R-1)));
				}
				
				else if(move > (cur.r - 1)) {
					nr = 1 + (move - (cur.r - 1));
				}
				else {
					nr = cur.r - move;
				}
				
			}
			
			// 아래
			else if(curDir == 2) {
				nc = cur.c;
				move = (time*cur.s) % (2*(R-1));
				
				if(move > ((R - cur.r) + (R-1))){
					nr = 1 + (move - ((R - cur.r) + (R-1)));
				}
				
				else if(move > (R - cur.r)) {
					nr = R - (move - (R - cur.r));
				}
				else {
					nr = cur.r + move;
				}
		
			}
			
			// 오른쪽
			else if(curDir == 3) {
				nr = cur.r;
				move = (time*cur.s) % (2*(C-1));
				
				if(move > ((C - cur.c) + (C-1))) {
					nc = 1 + (move - ((C - cur.c) + (C-1)));
				}
				
				else if(move > (C - cur.c)) {
					nc = C - (move - (C - cur.c));
				}
				else {
					nc = cur.c + move;
				}
			}
			
			// 왼쪽
			else {
				nr = cur.r;
				move = (time*cur.s) % (2*(C-1));
				
				if(move > ((cur.c - 1) + (C-1))) {
					nc = C - (move - ((cur.c - 1) + (C-1)));
				}
				
				else if(move > (cur.c - 1)) {
					nc = 1 + (move - (cur.c - 1));
				}
				else {
					nc = cur.c - move;
				}
			}
			
			if(map[nr][nc] == 0) {
				map[nr][nc] = cur.z;
				sharkIdx[nr][nc] = i;
			}
			else {
				if(cur.z > map[nr][nc]) {
					map[nr][nc] = cur.z;
					removeIdx.add(sharkIdx[nr][nc]);
					sharkIdx[nr][nc] = i;
				}
				else if(cur.z < map[nr][nc]) {
					removeIdx.add(i);
				}
			}
		}
	}
	
	static void remove() {
		Collections.sort(removeIdx, Collections.reverseOrder());
		
		for(Integer i : removeIdx) {
			sharkList.remove(i.intValue());
		}
	}

}