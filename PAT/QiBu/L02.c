#include <stdio.h>

int main() {
    int a, i, count = 0;
    scanf("%d", &a);
    for (i = 5; i <= a; i += 2) {
        if (isPrimePro(i)) {
            count++;
            // printf("%d %d\n", i, i - 2);
        }
    }
    printf("%d", count);
    return 0;
}
int isPrimePro(int num) {
    int i, isprime = 1;
    if (num < 1) {
        isprime = 0;
    }
    for (i = 3; i < num; i += 2) {
        if (num % i == 0 || ((num - 2) % i == 0 && i < num - 2)) {
            isprime = 0;
            break;
        }
    }
    return isprime;
}
int isPrime(int num) {
    int i, isprime = 1;
    if (num < 1) {
        isprime = 0;
    }
    for (i = 2; i < num; i++) {
        if (num % 2 == 0 || num % i == 0) {
            isprime = 0;
            break;
        }
    }
    return isprime;
}