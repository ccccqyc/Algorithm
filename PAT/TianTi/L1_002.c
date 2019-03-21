#include <stdio.h>

int main() {
    // temp * numbers
    // i 单边行数
    // j,k the temp num
    int a, count = 0, i = 0, temp = 0, j, k;
    char c;
    scanf("%d %c", &a, &c);
    while (temp < a) {
        i++;
        temp = 2 * i * i - 1;
        if ((2 * (i + 1) * (i + 1) - 1) > a) {
            break;
        } else if ((2 * (i + 1) * (i + 1) - 1) == a) {
            temp = (2 * (i + 1) * (i + 1) - 1);
            i++;
            break;
        }
    }
    for (j = i; j >= 1; j--) {
        for (k = i - j; k > 0; k--) {
            printf(" ");
        }
        for (k = 2 * j - 1; k > 0; k--) {
            printf("%c", c);
        }
        printf("\n");
    }
    for (j = 2; j <= i; j++) {
        for (k = i - j; k > 0; k--) {
            printf(" ");
        }
        for (k = 1; k <= 2*j-1; k++) {
            printf("%c", c);
        }
        printf("\n");
    }

    printf("%d", (a - temp));

    return 0;
}