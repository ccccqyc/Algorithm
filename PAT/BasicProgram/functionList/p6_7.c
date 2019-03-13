#include <stdio.h>
#include <math.h>


int IsTheNumber ( const int N );

int main() {
	int n1, n2, i, cnt;

	scanf("%d %d", &n1, &n2);
	cnt = 0;
	for ( i=n1; i<=n2; i++ ) {
		if ( IsTheNumber(i) ) {
			printf("%d\n",i);
			cnt++;
		}
	}
	printf("cnt = %d\n", cnt);

	return 0;
}

int IsTheNumber (const int N ) {
	int isSquare = sqrt(N);
	int a[10]= {0},copyN = N,temp = 0,index;
	if(isSquare * isSquare == N) {
		while(copyN) {
			index = copyN % 10;
			copyN /=10;
			a[index]++;
			if(a[index]==2) {
				temp=1;
				break;
			}
		}
	}
	return temp;
}

