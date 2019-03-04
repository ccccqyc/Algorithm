#include <stdio.h>

#define N 10

void quicksort(int a[], int low, int high);
int split(int a[], int low, int high);

int main(int argc, char const *argv[])
{
    int a[N], i;

    printf("Enter %d numbers to be sorted:", N);
    for (i = 0; i < N; i++)
    {
        scanf("%d", &a[i]);
    }

    quicksort(a, 0, N - 1);

    printf("In sorted order: ");
    for (i = 0; i < N; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\n");
    return 0;
}

void quicksort(int a[], int low, int high)
{
    int middle;

    if (low >= high)
        return;
    middle = split(a, low, high);
    quicksort(a, low, middle - 1);
    quicksort(a, middle + 1, high);
    return;
}

int split(int a[], int low, int high)
{
    int partelement = a[low];

    for (;;)
    {
        while (low < high && a[high] >= partelement)
        {
            high--;
        }
        if (low > high)
        {
            break;
        }
        a[low++] = a[high];

        while (low < high && a[low] <= partelement)
        {
            low++;
        }
        if (low >= high)
        {
            break;
        }
        a[high--] = a[low];
    }

    a[high] = partelement;

    return high;
}
