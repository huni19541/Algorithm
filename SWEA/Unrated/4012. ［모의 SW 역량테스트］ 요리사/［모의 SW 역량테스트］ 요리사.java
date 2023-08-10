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
			int min = Integer.MAX_VALUE;
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] S = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] flag = new int[N];
			for(int i=0; i<N/2; i++) {
				flag[i] = 1;
			}
			Arrays.sort(flag);
			
			int[] flag2 = new int[N/2];
			for(int i=0; i<2; i++) {
				flag2[i] = 1;
			}
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = i+1;
			}
			
			do {
				
				int idx = 0, idx2 = 0, sum = 0, sum2 = 0;
				int[] temp = new int[N/2];
				int[] temp2 = new int[N/2];
				
				for(int i=0; i<N; i++) {
					if(flag[i] == 1) {
						temp[idx++] = arr[i];
					} else {
						temp2[idx2++] = arr[i];
					}
				}

				Arrays.sort(flag2);
				do {
					int numIdx = 0;
					int[] nums = new int[2];
					for(int i=0; i<N/2; i++) {
						if(flag2[i] == 1) {
							nums[numIdx++] = temp[i];
						}
					}
					sum += S[nums[0]-1][nums[1]-1];
					sum += S[nums[1]-1][nums[0]-1];
					
				} while(np(flag2));
				
				Arrays.sort(flag2);
				do {
					int numIdx = 0;
					int[] nums = new int[2];
					for(int i=0; i<N/2; i++) {
						if(flag2[i] == 1) {
							nums[numIdx++] = temp2[i];
						}
					}
					sum2 += S[nums[0]-1][nums[1]-1];
					sum2 += S[nums[1]-1][nums[0]-1];
					
				} while(np(flag2));
				
				min = Math.min(min, Math.abs(sum - sum2));
				
			} while(np(flag));
			
			sb.append('#').append(tc).append(" ").append(min).append('\n');
		}
		System.out.println(sb);
	}
	
	private static boolean np(int[] p) {
		int N = p.length;
		
		int i = N-1;
		
		while(i > 0 && p[i-1] >= p[i]) i--;
		
		if(i == 0) return false;
		
		int j = N-1;
		
		while(p[i-1] >= p[j]) j--;
		swap(p, i-1, j);
		
		int k = N-1;
		while(i < k) {
			swap(p, i++, k--);
		}
		
		return true;
	}

	private static void swap(int[] p, int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}
	
}