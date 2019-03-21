#include <math.h>
#include <stdio.h>

int prime(int p);
int PrimeSum(int m, int n);

int main() {
    int m, n, p;

    scanf("%d %d", &m, &n);
    printf("Sum of ( ");
    for (p = m; p <= n; p++) {
        if (prime(p) != 0)
            printf("%d ", p);
    }
    printf(") = %d\n", PrimeSum(m, n));

    return 0;
}

int prime(int p) {
    int isP = 1, i;

    if (p <= 1) {
        return 0;
    }
    for (i = 2; i < p; i++) {
        if (p % i == 0) {
            isP = 0;
            break;
        }
    }
    return isP;
}
int PrimeSum(int m, int n) {
    int sumP = 0, i;

    for (i = m; i <= n; i++) {
        if (prime(i)) {
            sumP += i;
        }
    }
    return sumP;
}