#include <cstdio>
#include <stdlib.h>
//N皇后问题,暴力解法,全排列.
const int maxn = 11;
int count=0;
int n,P[maxn],hashTable[maxn] = {false};
void generateP(int index) {
	//递归边界
	if(index == n+1) {
		bool flag = true;
		for(int i = 1; i <= n; i++) {
			for(int j = i + 1; j <= n; j++) {
				//对角线 行坐标差 == 列坐标差
				if(abs(i - j) == abs(P[i] - P[j])) {
					flag = false;
				}
			}
		}
		if(flag) count++;
		return;
	}

	//递归式
	for(int x = 1; x <= n; x++) {
		if(hashTable[x] == false) {
			P[index] = x;
			hashTable[x] = true;
			generateP(index + 1);
			hashTable[x] =false;
		}
	}
}

int main() {
	n = 8;
	//全排列 从1开始
	generateP(1);
	printf("%d",count);
	return 0;
}
