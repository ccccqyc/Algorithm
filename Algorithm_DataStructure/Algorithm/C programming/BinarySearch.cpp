#include <cstdio>
//A[] �����ϸ����,left �����½�, right �����Ͻ�,x��ѯ��
//�������� ����ұ� [left,right] ,�����ֵ[0,n-1]

int binarySearch(int A[],int left,int right,int x) {
	int mid; //�е�
	while(left <= right) {
	    //��ֹ����̫��,left+right Խ�� int �ķ�Χ
		mid = left + (right - left) / 2;
		if(A[mid] == x) return mid;
		else if(A[mid] > x) {
			right = mid -1;
		} else {
			left = mid + 1;
		}
	}
	return -1;
}

int main() {
	const int n = 10;
	int A[n] = {1,3,5,6,7,8,10,11,12,15};
	printf("%d %d\n",binarySearch(A,0,n-1,6),binarySearch(A,0,n-1,9));
	return 0;
}

