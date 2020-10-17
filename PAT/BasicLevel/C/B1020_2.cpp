#include <algorithm>
#include <cstdio>
using namespace std;

struct mooncake {
    float sall;
    int stock;
    float price;
};

bool cmp(mooncake m1, mooncake m2) { return m1.price > m2.price; }
int main() {
    int N;
    float D;
    scanf("%d %f", &N, &D);
    mooncake mcs[N];
    for (int i = 0; i < N; i++) {
        scanf("%d", &mcs[i].stock);
    }
    for (int i = 0; i < N; i++) {
        scanf("%f", &mcs[i].sall);
        mcs[i].price = mcs[i].sall / mcs[i].stock;
    }
    sort(mcs, mcs + N, cmp);

    float income = 0;
    for (int i = 0; i < N; i++) {
        if (mcs[i].stock <= D) {
            income += mcs[i].sall;
            D -= mcs[i].stock;
        } else {
            income += mcs[i].price * D;
            break;
        }
    }
    printf("%.2f", income);

    return 0;
}