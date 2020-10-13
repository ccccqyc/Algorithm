#include <string.h>

#include <algorithm>
#include <cstdio>
using namespace std;
struct student {
    char id[15];
    int score;
    int location_number;
    int local_rank;
} arr[30010];
bool cmp(student a, student b) {
    if (a.score != b.score) {
        return a.score > b.score; //a.score = 15 b.score = 20 false 排序方式从小到大 a b
    } else {
        return strcmp(a.id, b.id) < 0; //a.id ="123" b.id="122" 返回正数 <0 false 排序 b a
    }
}

int main() {
    int N = 0, n = 0, index = 0;
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        scanf("%d", &n);
        for (int j = 0; j < n; j++) {
            scanf("%s %d", arr[index].id, &arr[index].score);
            arr[index].location_number = i + 1;
            index++;
        }

        sort(arr + index - n, arr + index, cmp);
        arr[index - n].local_rank = 1;
        for (int j = 0; j < n; j++) {
            if (arr[index - n + j].score == arr[index - n + j + 1].score) {
                arr[index - n + j + 1].local_rank =
                    arr[index - n + j].local_rank;
            } else {
                arr[index - n + j + 1].local_rank = j + 2;
            }
        }
    }
    printf("%d\n", index);
    sort(arr,arr+index,cmp);
    int frank = 1;
    for (int i = 0; i < index; i++) {
        if (i > 0 && arr[i].score != arr[i - 1].score) {
            frank = i + 1;
        }
        printf("%s %d %d %d\n", arr[i].id, frank, arr[i].location_number,
               arr[i].local_rank);
    }
    return 0;
}