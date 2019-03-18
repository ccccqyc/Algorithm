#include <stdio.h>

int narcissistic(int number);
void PrintN(int m, int n);

int main() {
    int m, n;

    scanf("%d %d", &m, &n);
    if (narcissistic(m))
        printf("%d is a narcissistic number\n", m);
    PrintN(m, n);
    if (narcissistic(n))
        printf("%d is a narcissistic number\n", n);

    return 0;
}

int narcissistic(int number) {
    int isNar = 0, temp = number, i, count = 0;
    double sum = 0;
    while (temp) {
        count++;
        temp /= 10;
    }
    int list[5] = {0};
    temp = number;
    for (i = 0; i < count; i++) {
        list[i] = temp % 10;
        temp /= 10;
        sum += pow(list[i], count);
    }

    if (sum == number) {
        isNar = 1;
    }

    return isNar;
}
void PrintN(int m, int n) {
    int i, count = 0;
    for (i = m + 1; i < n; i++) {
        if (narcissistic(i)) {
            printf("%d\n", i);
        }
    }
}