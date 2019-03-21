#include <stdio.h>

#define MAXN 10

int even(int n);
int OddSum(int List[], int N);

int main() {
    int List[MAXN], N, i;

    scanf("%d", &N);
    printf("Sum of ( ");
    for (i = 0; i < N; i++) {
        scanf("%d", &List[i]);
        if (even(List[i]) == 0)
            printf("%d ", List[i]);
    }
    printf(") = %d\n", OddSum(List, N));

    return 0;
}

int even(int n) { return n % 2 == 0 ? 1 : 0; };
int OddSum(int List[], int N) {
    int i, sum = 0;
    ;
    for (i = 0; i < N; i++) {
        if (!even(List[i])) {
            sum += List[i];
        }
    }

    return sum;
};