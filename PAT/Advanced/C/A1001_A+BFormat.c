#include <stdio.h>
#include <stdlib.h>

void main(int argc, char const *argv[])
{
    int num1, num2, num3;
    scanf("%d%d", &num1, &num2);
    num3 = num1 + num2;
    if (num3 < 0)
    {
        printf("-");
        num3 = -num3;
    }

    int num4 = num3;
    int count = 1;
    while (num4 >= 10)
    {
        num4 /= 10;
        count++;
    }

    if (count > 3)
    {

    }
    else
    {
        printf("%d", num3);
    }
    return;
}
