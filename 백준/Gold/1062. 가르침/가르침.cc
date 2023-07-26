#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <string>
#include <stack>

using namespace std;

int N, K, res;
vector<string> v;
string str;

bool check[26];

void func(int start, int cnt)
{
	if (cnt == K)
	{
		int temp = 0;
		for (int i = 0; i < N; i++)
		{
			bool flag = true;

			for (int j = 0; j < v[i].size(); j++)
			{
				if (!check[v[i][j] - 'a'])
				{
					flag = false;
					break;
				}
			}

			if (flag)
				temp++;
		}
		res = max(res, temp);
		return;
	}

	for (int z = start; z < 26; z++)
	{
		if (!check[z])
		{
			check[z] = true;
			func(z, cnt + 1);
			check[z] = false;
		}
	}
}

int main(int argc, char* argv[])
{
	cin >> N >> K;

	if (K < 5)
	{
		printf("0");
		return 0;
	}
	else if (K == 26)
	{
		printf("%d", N);
		return 0;
	}

	K -= 5;
	for (int i = 0; i < N; i++)
	{
		cin >> str;
		v.push_back(str);

		v[i] = v[i].substr(4, v[i].length());

		for (int j = 0; j < 4; j++)
			v[i].pop_back();
	}

	check['a' - 'a'] = true;
	check['c' - 'a'] = true;
	check['i' - 'a'] = true;
	check['n' - 'a'] = true;
	check['t' - 'a'] = true;

	func(0, 0);
	printf("%d", res);
}