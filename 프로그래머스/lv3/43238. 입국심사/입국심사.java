import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
		long answer = 0;

		Arrays.sort(times);

		long min = 0;
		long max = (long) n * times[times.length - 1];
		long sum;

		while (min <= max) {
			long mid = (min + max) / 2;

			sum = 0;
			for (int t : times)
				sum += (mid / t);

			if (sum >= n) {
				max = mid - 1;
				answer = mid;
			} else {
				min = mid + 1;
			}
		}

		return answer;
	}
}