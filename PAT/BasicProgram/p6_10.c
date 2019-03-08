#include <stdio.h>

void Print_Factorial ( const int N );

int main() {
	int N;

	scanf("%d", &N);
	Print_Factorial(N);
	return 0;
}

void Print_Factorial ( const int N ) {
	int a[3000];
	int temp,num,digit;
	int i,j;
	a[0]=1;
	digit=1
	if(N>=0) {
		for(i=2; i<=N; i++) {
			num=0;
			for(j=0; j<digit; j++) {
				temp=a[j]*i+num;
				a[j]=temp%10;
				num=temp/10;
			}
			while(num) {
				a[digit]=num%10;
				num/=10;
				digit++;
			}
		}
		for(i=digit-1; i>=0; i--) {
			printf("%d",a[i]);
		}
	} else printf("Invalid input");

}
