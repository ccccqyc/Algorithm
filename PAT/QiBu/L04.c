#include <stdio.h>

int main() {
    int i, arr[20] = {-1};
    for (i = 0; getchar() != "\n"; i++) {
        arr[i] = getchar();
    }

    printf("%d",arr[0]);
    return 0;
}