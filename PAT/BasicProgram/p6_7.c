#include <stdio.h>
#include <math.h>


int IsTheNumber ( const int N );

int main()
{
    int n1, n2, i, cnt;
	
    scanf("%d %d", &n1, &n2);
    cnt = 0;
    for ( i=n1; i<=n2; i++ ) {
        if ( IsTheNumber(i) )
            cnt++;
    }
    printf("cnt = %d\n", cnt);

    return 0;
}

int IsTheNumber ( const int N ){
	int temp = 0;
	if(IsSquare(N)&&IsSim(N)){
		temp=1;
	}	
	return temp;
}

int IsSquare(const int N){
	int isSquare=0,temp=N,i=1;
	for(i;i<=temp/2;i++){
		if(i*i==temp){
			isSquare=1;
			break;
		}
	}
	return isSquare;
	
	return isSquare;
}

int IsSim(const int N){
	s
}
