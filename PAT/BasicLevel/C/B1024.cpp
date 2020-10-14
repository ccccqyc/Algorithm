#include <algorithm>
#include <cmath>
#include <iostream>
#include <map>
using namespace std;

int main() {
    char line[100000];
    int exponent;
    scanf("%[^E]E%d", line, &exponent);
    char *p = line;

    if (*p == '-') printf("%c", '-');
    p++;
    if (exponent >= 0) {
        putchar(*p);
        p++;
        p++;  //跳过小数点
        for (; exponent > 0; exponent--) {
            printf("%c", *p ? *p : '0');
            p++;
        }
        if (*p) {
            printf(".");
            while (*p) printf("%c", *p++);
        }
    } else {
        printf("0.");
        for (exponent++; exponent < 0; exponent++) printf("0");
        while (*p) {
            if (*p != '.') printf("%c", *p);
            p++;
        }
    }
    return 0;
}