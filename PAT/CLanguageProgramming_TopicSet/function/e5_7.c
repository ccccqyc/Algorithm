#include <math.h>
#include <stdio.h>

double funcos(double e, double x);

int main() {
    double e, x;

    scanf("%lf %lf", &e, &x);

    printf("cos(%.2f) = %.6f\n", x, funcos(e, x));

    return 0;
}
double funcos(double e, double x) {
    double err = 1, sum = 0, temppow = 1, tempfac = 1;
    int i;
    for (i = 2; err > e; i += 2) {
        temppow *= x * x;
        tempfac *= i * (i - 1);
        err = temppow / tempfac;
        sum += pow(-1, i / 2) * err;
    }

    return sum;
}