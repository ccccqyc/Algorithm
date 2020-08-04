#include <cstdio>

int main() {
	int row,clo;
	char c;
	scanf("%d %c",&clo,&c);
	if(clo%2==1) {
		row = clo/2+1;
	} else {
		row = clo/2;
	}
	for(int i =0; i<clo; i++) {
		printf("%c",c);
	}
	printf("\n");	
		
	for(int i =2; i<clo; i++) {
		printf("%c",c);
		for(int j=0; j<clo-2; j++) {
			printf(" ");
		}
		printf("%c\n",c);
	}

	for(int i = 0; i<clo; i++) {
		printf("%c",c);
	}

	return 0;

}
