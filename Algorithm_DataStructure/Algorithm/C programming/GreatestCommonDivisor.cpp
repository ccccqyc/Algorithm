#include <cstdio>

//最大公约数
int gcd(int a ,int b) {
	return !b?a :gcd(b,a%b);
}

int main() {
	int a,b;
	scanf("%d %d",&a,&b);
	printf("%d",gcd(a,b));
	return 0;
}
