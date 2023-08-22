#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>

int main(int argc, char* argv[]) {

	int N;
	scanf("%d", &N);

	int dp[50001];
	for (int i = 0; i <= 50000; i++)
		dp[i] = 999999;

	for (int i = 1; i <= (int)sqrt(N); i++)
		dp[i*i] = 1;

	for (int i = 2; i <= N; i++) {
		int start = 1;

		while (start*start <= i / 2) {
			dp[i] = std::min(dp[start*start] + dp[i - start * start], dp[i]);
			start++;
		}
	}

	printf("%d", dp[N]);
	return 0;
}