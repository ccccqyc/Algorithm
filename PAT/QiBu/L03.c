#include <stdio.h>

int main() {
    int a, b;
    scanf("%d %d", &a, &b);
    int array[a], i;
    for (i = 0; i < a; i++) {
        scanf("%d", &array[i]);
    }
    while (b >= a) {
        b -= a;
    }

    for (i = 0; i < a; i++) {
        if (i < b) {
            printf("%d", array[a - b + i]);
        } else {
            printf("%d", array[i - b]);
        }
        if (i != a - 1) {
            printf(" ");
        }
    }
    return 0;
}