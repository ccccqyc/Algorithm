#include <stdio.h>
int f(int &num1, int &num2) {
    int temp = num1;
    num1 = num2;
    num2 = num1 + temp;
    return num1 + num2;
}

int main() {
    int n = 0, num1 = 0, num2 = 1;
    scanf("%d", &n);
    while (f(num1, num2) < n)
        ;
    int temp = num1;
    num1 = num2;
    num2 = num1 + temp;
    printf("%d", (n - num1) <= (num2 - n) ? num1 : num2);
    return 0;
}