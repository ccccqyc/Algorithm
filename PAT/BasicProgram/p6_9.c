#include <stdio.h>

int Count_Digit ( const int N, const int D );

int main() {
	int N, D;

	scanf("%d %d", &N, &D);
	printf("%d\n", Count_Digit(N, D));
	return 0;
}

int Count_Digit ( const int N, const int D ) {
	int a[10] = {0},copyN = N,index;
	if(copyN<0){
		copyN =-copyN;
	}
	do{
		index = copyN%10;
		copyN /=10;
		a[index]++;
	}while(copyN);
	return a[D];
}
