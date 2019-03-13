#include <stdio.h>
#include <stdlib.h>

typedef struct Node *PtrToNode;
struct Node {
    int Data; /* �洢������� */
    PtrToNode Next; /* ָ����һ������ָ�� */
};
typedef PtrToNode List; /* ���嵥�������� */

int FactorialSum( List L );

int main()
{
    int N, i;
    List L, p;

    scanf("%d", &N);
    L = NULL;
    for ( i=0; i<N; i++ ) {
        p = (List)malloc(sizeof(struct Node));
        scanf("%d", &p->Data);
        p->Next = L;  L = p;
    }
    printf("%d\n", FactorialSum(L));

    return 0;
}
int FactorialSum( List L ){
	int sum=0,temp= 0;
	
	while(L){
		temp=L->Data;		
		sum+=Factorial(temp);
		L=L->Next;
	}
	return sum;
}

int Factorial(int a){
	int temp=1,i;
	for(i=1;i<=a;i++){
		temp *=i;
	}
	
	return temp;
}
