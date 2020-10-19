#include <cstdio>

using namespace std;

int main() {
    int arr[10] = {0};
    for (int i = 0; i < 10; i++) {
        scanf("%d", &arr[i]);
    }
    for (int i = 1; i < 10; i++) {
        if (arr[i] > 0) {
            printf("%d", i);
            arr[i]--;
            break;
        }
    }
    int count=0;
    for (int i = 0; i < 10; i++) {
        if (arr[i] > 0) {
            count = arr[i];
            for (int j = 0; j < count; j++) {
                printf("%d", i);
                arr[i]--;
            }
        }
    }
    return 0;
}