#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <string>
#include <stack>

using namespace std;

int main(int argc, char* argv[])
{
	int N, t1, t2;
	cin >> N;

	vector<pair<int, int>> v;

	for (int i = 0; i < N; i++)
	{
		cin >> t1 >> t2;
		v.push_back({ t2, t1 });
	}

	sort(v.begin(), v.end());

	int cnt = 1;
	int time = v[0].first;
	for (int i = 1; i < N; i++)
	{
		if (time <= v[i].second)
		{
			cnt++;
			time = v[i].first;
		}
	}
	printf("%d", cnt);
}