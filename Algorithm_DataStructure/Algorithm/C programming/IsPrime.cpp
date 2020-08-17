#include <cstdio>
#include <math.h>
//ËØÊıÅĞ¶Ï Ö§³Å10^5 
bool isPrime(int n) {
	if(n <=1) return false;
	int  sqr = (int)sqrt(1.0*n);
	for(int i=2; i<sqr; i++) {
		if(n%i == 0) return false;
	}
	return true;
}

int main() {
	int a;
	scanf("%d",&a);
	printf("%d",isPrime(a));
	return 0;
}
