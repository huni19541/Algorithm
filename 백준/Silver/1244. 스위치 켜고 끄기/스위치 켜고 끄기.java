import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 스위치 개수
		int[] sArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		// 스위치 입력
		for(int i=0; i<N; i++) {
			sArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine()); // 학생 수
		
		int gender, number;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			gender = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());
			
			B1244(sArr, N, gender, number);
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(sArr[i-1]).append(" ");
			if(i%20 == 0) {
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static void B1244(int[] switchArr, int switchNum, int gender, int number) {
		if(gender == 1) {
			for(int i=0; i<switchNum; i++) {
				if((i+1)%number == 0) {
					switchArr[i] = (switchArr[i] == 1) ? 0 : 1;
				}
			}
		}
		else {
			int dist = 0;
			int curIdx = number - 1;
			
			while((switchArr[curIdx - dist] == switchArr[curIdx + dist])) {
				if(dist == 0) {
					switchArr[curIdx] = (switchArr[curIdx] == 1) ? 0 : 1;
				} else {
					switchArr[curIdx - dist] = (switchArr[curIdx - dist] == 1) ? 0 : 1;
					switchArr[curIdx + dist] = (switchArr[curIdx + dist] == 1) ? 0 : 1;
				}
				dist++;
				
				if(curIdx-dist < 0 || curIdx+dist >= switchNum) break;
			}
		}
	}

}