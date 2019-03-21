#include <stdio.h>

int CountDigit(int number, int digit);

int main() {
    int number, digit;

    scanf("%d %d", &number, &digit);
    printf("Number of digit %d in %d: %d\n", digit, number,
           CountDigit(number, digit));

    return 0;
}
int CountDigit(int number, int digit) {
    int count = 0, temp = number;
    if (number < 0) {
        number = -number;
    }

    while (number) {
        if (number % 10 == digit) {
            count++;
        }
        number /= 10;
    }

    if (temp == 0 && digit == 0) {
        count = 1;
    }

    return count;
}