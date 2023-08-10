import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("Test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int winCnt = 0;
			int loseCnt = 0;
			
			// 규영이가 받은 숫자와 다른 숫자를 인영이가 가져야 하므로 체크하기 위해 boolean배열 선언
			boolean[] check = new boolean[19];
			
			// 규영이의 카드 배열 : arr
			// 인영이의 카드 배열 : arr2
			int[] arr = new int[9];
			int[] arr2 = new int[9];
			
			// 규영이가 받은 숫자를 배열에 저장하고 boolean배열에 true저장
			for(int i=0; i<9; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;
				check[num] = true;
			}
			
			// 규영이가 받지 않은 숫자들을 인영이 배열에 저장
			int idx = 0;
			for(int i=1; i<=18; i++) {
				if(!check[i]) arr2[idx++] = i;
			}
			
			// NP를 돌리기 위해 인영이의 배열을 오름차순으로 정렬
			Arrays.sort(arr2);
			
			do {
				int sum = 0;
				int sum2 = 0;
				
				for(int i=0; i<9; i++) {
					int num = arr[i];
					int num2 = arr2[i];
					
					// 두 값이 같을 떄
					if(num == num2) continue;
					
					// 두 값이 다를 때
					if(num > num2)
						sum += (num+num2);
					else
						sum2 += (num+num2);
				}
				
				if(sum > sum2) winCnt++;
				else if(sum < sum2) loseCnt++;
				
			} while(np(arr2));
			
			sb.append('#').append(tc).append(" ").append(winCnt).append(" ").append(loseCnt).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static boolean np(int[] p) {
		int N = p.length;
		
		//1. 꼭대기에서 꺾이는 위치 찾기
		int i = N-1;
		while(i > 0 && p[i-1] >= p[i]) i--;
		
		if(i == 0) return false;
		
		//2. i-1위치와 교환할 큰 값 찾기
		int j = N-1;
		while(p[i-1] >= p[j]) j--;
		
		//3. 교환
		swap(p, i-1, j);
		
		//3. 꼭대기 이후 오름차순 정렬
		int k = N-1;
		while(i < k) {
			swap(p, i++, k--);
		}
		
		return true;
	}

	static void swap(int[] p, int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}
}