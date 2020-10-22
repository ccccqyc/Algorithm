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

int main() { return 0; }