#include <stdio.h>

int main() {
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
        for (k = 2 * (i - j) - 1; k <= i; k++) {
            printf("%c", c);
        }
        printf("\n");
    }

    printf("%d", (a - 2 * i * i + 1));

    return 0;
}