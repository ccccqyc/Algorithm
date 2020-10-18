#include <algorithm>
#include <cstdio>
using namespace std;

struct mooncake {
    double sall;
    double stock;
    double price;
};

bool cmp(mooncake m1, mooncake m2) { return m1.price > m2.price; }
int main() {
    int N;
    double D;
    mooncake  mcs[1010];
    scanf("%d %lf", &N, &D);
    for (int i = 0; i < N; i++) {
        scanf("%lf", &mcs[i].stock);
    }
    for (int i = 0; i < N; i++) {
        scanf("%lf", &mcs[i].sall);
        mcs[i].price = mcs[i].sall / mcs[i].stock;
    }
    sort(mcs, mcs + N, cmp);

    double income = 0;
    for (int i = 0; i < N; i++) {
        if (mcs[i].stock <= D) {
            income += mcs[i].sall;
            D -= mcs[i].stock;
        } else {
            income += mcs[i].price * D;
            break;
        }
    }
    printf("%.2lf", income);

    return 0;
}