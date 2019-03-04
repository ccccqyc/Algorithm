#include <stdio.h>

int Factorial( const int N );

int main()
{
    int N, NF;
	
    scanf("%d", &N);
    NF = Factorial(N);
    if (NF)  printf("%d! = %d\n", N, NF);
    else printf("Invalid input\n");

    return 0;
}

int Factorial( const int N ){
	int temp;
	if(N<0){
		temp = 0;
	}else if(N==0){
		temp=1;
	}else{
		int i=1;
		temp =1; 
		for(i;i<=N;i++){
			temp *=i; 
		}
	}
	return temp;
}
