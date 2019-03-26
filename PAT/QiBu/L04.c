#include <stdio.h>

int main() {
    //int 的范围 2^32
    int i, length=0, arrint[20] = {-1},length2;
    char arr[20] = {-1};
    for (i = 0; (arr[i] = getchar()) != '\n'; i++) {
        printf("%d", arr[i] - 48);
        arrint[i] = arr[i] - 48;
        length ++;
    }

    int num = 2,temp;
    for( i = 0; i < length; i++)
    {
        temp = arrint[i] + num;
    }
    


    // printf("%d", arr[0]-48);
    return 0;
}