#include <cstdio>
#include <stdlib.h>
//N�ʺ�����,���ݷ�
const int maxn = 11;
int count=0;
int n,P[maxn],hashTable[maxn] = {false};
void generateP(int index) {
	// �ݹ�߽� 
	if(index == n+1) {
		count ++ ;
		return;
	}
	
	//�ݹ�ʽ 
	for(int x = 1; x <= n; x++) {
		if(hashTable[x] == false) {
			bool flag = true;
			for(int pre = 1; pre < index; pre++) {
				if(abs(index - pre) == abs(x - P[pre])) {
					flag = false;
					break;
				}
			}
			if(flag) {
				P[index] = x;
				hashTable[x] = true;
				generateP(index + 1);
				hashTable[x] =false;
			}
		}
	}
}

int main() {
	n = 8;
	//ȫ���� ��1��ʼ
	generateP(1);
	printf("%d",count);
	return 0;
}
