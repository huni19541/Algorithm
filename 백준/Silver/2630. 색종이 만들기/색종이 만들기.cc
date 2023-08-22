#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>
#include <queue>
using namespace std;

static int white, blue;
static int map[128][128];

bool check(int N, int R, int C, int num) {
	for (int i = R; i < R + N; i++) {
		for (int j = C; j < C + N; j++) {
			if (map[i][j] != num)
				return false;
		}
	}
	if (num == 1) blue++;
	else white++;

	return true;
}

void DQ(int N, int R, int C) {
	if (N == 0 || check(N, R, C, 0) || check(N, R, C, 1))
		return;

	DQ(N / 2, R, C);
	DQ(N / 2, R + N / 2, C);
	DQ(N / 2, R, C + N / 2);
	DQ(N / 2, R + N / 2, C + N / 2);
	return;
}


int main(int argc, char* argv[]) {

	int N;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%1d", &map[i][j]);
		}
	}

	DQ(N, 0, 0);

	printf("%d\n%d\n", white, blue);
	
	return 0;
}