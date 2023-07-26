#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <string>
#include <stack>

using namespace std;

const int MAX = 100 + 1;
int N, K;
int schedule[MAX], plug[MAX];

int main(int argc, char* argv[])
{
	cin >> N >> K;
	for (int i = 0; i < K; i++)
	{
		cin >> schedule[i];
	}

	int result = 0;
	for (int i = 0; i < K; i++)
	{
		bool pluggedIn = false;

		for (int j = 0; j < N; j++)
		{
			if (plug[j] == schedule[i])
			{
				pluggedIn = true;
				break;
			}
		}

		if (pluggedIn)
			continue;

		for (int j = 0; j < N; j++)
		{
			if (!plug[j])
			{
				plug[j] = schedule[i];
				pluggedIn = true;
				break;
			}
		}

		if (pluggedIn)
			continue;

		int idx, deviceIdx = -1;
		for (int j = 0; j < N; j++)
		{
			int lastIdx = 0;
			for (int k = i + 1; k < K; k++)
			{
				if (plug[j] == schedule[k])
					break;
				lastIdx++;
			}

			if (lastIdx > deviceIdx)
			{
				idx = j;
				deviceIdx = lastIdx;
			}
		}
		result++;

		plug[idx] = schedule[i];
	}
	printf("%d", result);
}