#include <cstdio>
const int maxN = 10010;
int main() {
	int T;
	scanf("%d",&T);

	while(T--) {
		int hashTable[100] = {-1};

		int N;
		scanf("%d",&N);
		int hashTable2[N][100]= {-1};

		for(int i=0; i<N; i++) {
			scanf("%d",hashTable[i]);
		}

		int maxNum=0;
		for(int i=0; i<N; i++) {
			int x;
			scanf("%d",&x);
			hashTable2[x][hashTable[i]]++;

			if(maxNum<x) {
				maxNum=x;
			}
		}

		for(int i = 1; i<=maxNum; i++) {

		}


	}
	return 0;
}
