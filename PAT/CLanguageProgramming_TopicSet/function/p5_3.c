#include <stdio.h>

void pyramid(int n);

int main() {
    int n;

    scanf("%d", &n);
    pyramid(n);

    return 0;
}
void pyramid(int n) {
    int i = n - 1, j, temp;
    for (i = n - 1; i >= 0; i--) {
        for (j = i; j > 0; j--) {
            printf(" ");
        }
        for (j = n - i; j > 0; j--) {
            temp = n - i;
            printf("%d ", temp);
        }
        if (i > 0) {
            printf("\n");
        }
    }
    return;
}
