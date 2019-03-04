#include <stdio.h>
#include <stdbool.h>

int main(int argc, char const *argv[])
{
    int length;
    scanf("%d", &length);
    int cheap[length];
    int i = length;
    for (i = 0; i < length; i++)
    {
        scanf("%d", &cheap[i]);
    }

    //the node number of degree is 0
    int count;
    if (length % 2 == 1)
    {
        count = (length + 1) / 2;
    }
    else
    {
        count = (length) / 2;
    }

    bool isMax = false;
    bool isMin = false;

    while (count != 0)
    {

        count--;
    }

    return 0;
}

int prt(int x,int arr[]){
    printf("");
    return 0;
}