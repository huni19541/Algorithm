import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> deque = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			// Test case 마다 deque 초기화
			deque.clear();
			AC();
		}
		
		System.out.println(sb);
	}
	
	static void AC() throws IOException {
		boolean reverse = false;

		// 입력
		String p = br.readLine();
		int pLen = p.length();
		int n = Integer.parseInt(br.readLine());
		String temp = br.readLine();

		// [ , , , ] 입력을 하나씩 나누어 deque에 추가
		if(n != 0) {
			String[] sArr = temp.substring(1, temp.length()-1).split(",");
			
			for(String s : sArr) {
				deque.add(Integer.valueOf(s));
			}
		}

		// p 함수 실행
		for(int i=0; i<pLen; i++) {
			char c = p.charAt(i);

			// R인 경우 boolean값 true/false 바꾸기
			if(c == 'R') {
				reverse = (reverse == true) ? false : true;
			}
			// D인 경우
			else if(c == 'D') {
				// deque가 비어있으면 sb에 "error\n"추가
				if(deque.size() == 0) {
					sb.append("error\n");
					return;
				}

				// 정방향이면 맨 앞 제거
				if(!reverse) {
					deque.pollFirst();
					n--;
				} 
				// 반대방향이면 맨 뒤 제거
				else {
					deque.pollLast();
					n--;
				}
			}
		}

		// 제거한 후 deque가 비어있으면 sb에 "[]\n"추가
		if(n == 0) {
			sb.append("[]\n");
			return;
		}

		// 비어있지 않은 경우 sb에 "[ , , , ]\n"형태로 추가 
		sb.append('[');
		if(!reverse) {
			sb.append(deque.pollFirst());
			while(!deque.isEmpty()) {
				sb.append(',').append(deque.pollFirst());
			}
			
		} else {
			sb.append(deque.pollLast());
			while(!deque.isEmpty()) {
				sb.append(',').append(deque.pollLast());
			}
		}
		sb.append("]\n");
	}
}
