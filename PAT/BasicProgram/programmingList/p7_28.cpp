#include <stdio.h>

//约瑟夫问题
int main()
{
    int i, n, sum = 0;
    scanf("%d", &n);
    for (i = 2; i <= n; i++)
    {
        sum = (sum + 3) % i;
    }
    printf("%d", sum + 1);
    return 0;
}
