#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
int level[100]；// 保存当前结点的所在层数 
int book[100];// 记录每层 
int maxlevel = -1;
vector<int> v[100];
void bfs() {
    queue<int> q;
    q.push(1);
    level[1] = 0;
    while(!q.empty()) {
    	// 获取队首元素 
        int index = q.front();
        q.pop();
        // 更新最大层数 
        maxlevel = max(level[index], maxlevel);
        if(v[index].size() == 0)
            book[level[index]]++;// 统计所在层数的叶子结点 
        // 对index结点的所有子结点进行遍历 
        for(int i = 0; i < v[index].size(); i++) {
            q.push(v[index][i]);// 子结点入队 
            level[v[index][i]] = level[index] + 1;// 同时记录结点的所在层次 
        }
    }
}
int main() {
    int n, m, k, node, c;
    scanf("%d %d", &n, &m);
    for(int i = 0; i < m; i++) {
        scanf("%d %d",&node, &k);
        for(int j = 0; j < k; j++) {
            scanf("%d", &c);
            v[node].push_back(c);
        }
    }
    bfs();
    printf("%d", book[0]);
    for(int i = 1; i <= maxlevel; i++)
        printf(" %d", book[i]);
    return 0;
}
