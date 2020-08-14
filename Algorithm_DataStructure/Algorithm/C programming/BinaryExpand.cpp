#include <cstdio>
#include <cmath>
const double eps = 1e-5;//精度 10^-5

//利用 二分法寻找 根号2 的近似值  开始
double f(double x) {
	return x * x;
}

double calSqrt() {
	double left = 1, right = 2 , mid;
	while(right - left > eps) {
		mid = (left + right) / 2;
		if(f(mid) > 2) {
			right = mid;
		} else {
			left = mid;
		}
	}

	return mid;
}

//根号2问题 结束

//装水问题
const double PI = acos(-1.0);
double f(double R,double h) {
	double alpha  = 2 * acos((R-h)/R);
	double L = 2 * sqrt(R*R-(R-h)*(R-h));
	double S2 = PI*R*R/2;
	double S1 = alpha * R * R / 2 - L * (R - h)/2;
	return S1 / S2;
}

double solve(double R, double r) {
	double left = 0, right = R, mid;
	while(right - left > eps) {
		mid = (left + right )/2;
		if(f(R,mid)>r) {
			right  = mid;
		} else {
			left = mid;
		}
	}
	return mid;
}
//装水问题 结束

int main() {
	printf("%f\n",calSqrt());
	//装水问题
	double R ,r;
	scanf("%lf%lf",&R,&r);
	printf("%.4f\n",solve(R,r));
	return 0;
}
