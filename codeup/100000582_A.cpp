#include <cstdio>

int main() {
	int n,m;
	while(scanf("%d%d",&n,&m)!=EOF) {
		int hashTable[205]= {0};
		int then[2000]= {0};
		for(int i = 0; i<n; i++) {
			scanf("%d",&then[i]);
			hashTable[then[i]]++;
		}
		for(int i = 0; i<n; i++) {
			if(hashTable[then[i]]>1) {
				printf("%d\n",hashTable[then[i]]-1);
			} else {
				printf("BeiJu\n");
			}
		}
	}
	return 0;
}
