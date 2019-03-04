#include <stdio.h>

void Print_Factorial ( const int N );

int main()
{
    int N;
	
    scanf("%d", &N);
    Print_Factorial(N);
    return 0;
}

void Print_Factorial ( const int N ){
	long temp=1l;
	
	if(N<0){
		printf("Invalid input");
		return;
	}else if(N==0){
		temp = 1;
	}else{
		int i = 1;
		for(i;i<=N;i++){
			temp *=i;
		}
	}
	
	printf("%d",temp);
}
