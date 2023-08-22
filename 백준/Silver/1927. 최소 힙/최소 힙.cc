#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>
#include <queue>
using namespace std;

int main(int argc, char* argv[]) {

	int N;
	scanf("%d", &N);

	priority_queue<int> pq;
	for (int i = 0; i < N; i++) {
		int num;
		scanf("%d", &num);

		if (num == 0) {
			if (pq.size() == 0)
				printf("%d\n", 0);
			else {
				printf("%d\n", -pq.top());
				pq.pop();
			}
		}
		else {
			pq.push(-num);
		}
	}
	return 0;
}