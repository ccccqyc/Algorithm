#include <stdio.h>

#define N 10

void selectSort(int A[])
{
    int lengthA =sizeof(A)/sizeof(A[0]);

    for (int i = 1; i < lengthA; i++)
    {
        int k = i,j=i;
        for (j = i; j < lengthA; j++)
        {
            if (A[k] > A[j])
            {
                k = j;
            }
        }
        int temp = A[i];
        A[i] = A[j];
        A[k] = temp;
    }
}
