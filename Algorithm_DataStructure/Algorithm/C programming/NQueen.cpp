#include <cstdio>
#include <stdlib.h>
//N�ʺ�����,�����ⷨ,ȫ����.
const int maxn = 11;
int count=0;
int n,P[maxn],hashTable[maxn] = {false};
void generateP(int index) {
	//�ݹ�߽�
	if(index == n+1) {
		bool flag = true;
		for(int i = 1; i <= n; i++) {
			for(int j = i + 1; j <= n; j++) {
				//�Խ��� ������� == �������
				if(abs(i - j) == abs(P[i] - P[j])) {
					flag = false;
				}
			}
		}
		if(flag) count++;
		return;
	}

	//�ݹ�ʽ
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
	//ȫ���� ��1��ʼ
	generateP(1);
	printf("%d",count);
	return 0;
}
