#include <stdio.h>

void main(void)
{
    int num;
    int count = 0;
    scanf("%d", &num);

    while (num != 1){
        if(num%2 ==1){
            num=(3*num+1)/2;
        }else{
            num =(num/2);
        }
        count++;
    }
    printf("%d",count);
    return ;
}
