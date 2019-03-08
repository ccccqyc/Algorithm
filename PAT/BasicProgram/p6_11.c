#include <stdio.h>

#define MAXN 10
typedef float ElementType;

ElementType Median( ElementType A[], int N );

int main () {
	ElementType A[MAXN];
	int N, i;

	scanf("%d", &N);
	for ( i=0; i<N; i++ )
		scanf("%f", &A[i]);
	printf("%.2f\n", Median(A, N));

	for(i =0; i<N; i++) {
		printf("%.2f",A[i]);
	}

	return 0;
}
ElementType Median( ElementType A[], int N ) {
	blsorts(A,N);
	return A[N/2];
}

int  blsorts(ElementType B[], int M) {
	ElementType temps;
	int i,j;
	for(i=0; i<M-1; i++) {
		for(j=0; j<M-1-i; j++) {
			if(B[j]>B[j+1]) {
				temps = B[j+1];
				B[j+1] = B[j];
				B[j]=temps;
			}
		}
	}
	return 1;
}


