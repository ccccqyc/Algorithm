#include <cstdio>
#include <algorithm>
using namespace std;

//分数
struct Fraction {
	int up,down;
};
int gcd(int a ,int b) {
	return !b?a :gcd(b,a%b);
}
//分数化简
Fraction reduction(Fraction result) {
	if(result.down < 0) {
		result.down = -result.down;
		result.up = result.up;
	}
	if(result.up == 0) {
		result.down = 1;
	} else {
		int d = gcd(abs(result.up),abs(result.down));
		result.up /=d;
		result.down /=d;
	}
	return result;
}

//分数输出
void showResult(Fraction r) {
	r  = reduction(r);
	if(r.down ==1) printf("%lld",r.up);
	else if(abs(r.up)>r.down) {
		printf("%d %d/%d",r.up/r.down,abs(r.up)%r.down,r.down);
	} else {
		printf("%d/%d",r.up,r.down);
	}
}
int main() {
	int a,b;
	scanf("%d %d",&a,&b);
	Fraction f;
	f.down = b;
	f.up = a;
	showResult(f);
	return 0;
}
