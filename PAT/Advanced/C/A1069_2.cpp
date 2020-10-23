#include <algorithm>
#include <cstdio>

using namespace std;

bool cmp(int a, int b) { return a > b; }

void to_array(int a, int num[]) {
    for (int i = 0; i < 4; i++) {
        num[i] = a % 10;
        a /= 10;
    }
}
int to_number(int num[]) {
    int temp = 0;
    for (int i = 0; i < 4; i++) {
        temp = temp * 10 + num[i];
    }
    return temp;
}

int main() {
    int n, MIN, MAX;
    scanf("%d", &n);
    int nums[5];

    while (1) {
        to_array(n, nums);
        sort(nums, nums + 4);
        MIN = to_number(nums);
        sort(nums, nums + 4, cmp);
        MAX = to_number(nums);
        n = MAX - MIN;
        printf("%04d - %04d = %04d\n", MAX, MIN, n);
        if (n == 0 || n == 6174) break;
    }

    return 0;
}