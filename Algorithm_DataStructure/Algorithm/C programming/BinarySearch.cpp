#include <cstdio>
//A[] 数组严格递增,left 二分下界, right 二分上界,x查询数
//二分区间 左闭右闭 [left,right] ,传入初值[0,n-1]

int binarySearch(int A[],int left,int right,int x) {
	int mid; //中点
	while(left <= right) {
	    //防止数组太大,left+right 越界 int 的范围
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

