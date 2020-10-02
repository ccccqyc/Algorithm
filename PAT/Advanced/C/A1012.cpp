#include<iostream>
#include<algorithm>
using namespace std;
const int maxn = 2e3 + 10;
struct node {
    int id, score[4];
}a[maxn];
int check[10000000][4];
int n, m, now;
char c[4] = { 'A','C','M','E' };
bool comp(node x,node y)
{
    return x.score[now] > y.score[now];
}
int main()
{
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d%d%d", &a[i].id, &a[i].score[1], &a[i].score[2], &a[i].score[3]);
        a[i].score[0] = a[i].score[1] + a[i].score[2] + a[i].score[3];
        for (int j = 0; j < 4; j++)check[a[i].id][j] = n+1;
    }
    for (now=0;now<4;now++)
    {
        sort(a, a + n, comp);
        check[a[0].id][now] = 1;
        for (int i = 1; i < n; i++)
        {
            if (a[i].score[now] == a[i - 1].score[now])
            {
                check[a[i].id][now] = check[a[i - 1].id][now];
            }
            else check[a[i].id][now] = i + 1;
        }
    }
    while (m--)
    {
        int x;
        scanf("%d", &x);
        if (check[x][0] != 0)
        {
            int k = 0;
            for (int i = 0; i < 4; i++)
            {
                if (check[x][i] < check[x][k])k = i;
            }
            printf("%d %c\n", check[x][k], c[k]);
        }
        else printf("N/A\n");
    }
    return 0;
}

