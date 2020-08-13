#include <cstdio>
//全排列
const int maxn = 11;

int n,P[maxn],hashTable[maxn] = {false};

void generateP(int index) {
	
	//递归边界 
	if(index == n + 1) {
		for(int i = 1; i<= n; i++) {
			printf("%d",P[i]);
		}
		printf("\n");
		return;
	}
	
	//递归式 
	for(int x = 1; x <= n; x++) {
		if(hashTable[x] == false) {
			P[index] = x;
			hashTable[x] = true;
			generateP(index + 1);
			hashTable[x] = false;
		}
	}
}
int main() {
	n = 3;
	generateP(1);
	return 0;
}
