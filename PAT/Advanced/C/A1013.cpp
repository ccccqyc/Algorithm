
#include<iostream>
#include<algorithm>
#define NODE_NUM 1001
using namespace std;

int v[NODE_NUM][NODE_NUM];
bool visited[NODE_NUM];
int N;
void dfs(int node){
    visited[node] = true;
    for(int i=1;i<=N;i++){
        if(visited[i]==false && v[node][i]==1)
            dfs(i);
    }
}

int main(){
    int M,K;
    ios_base::sync_with_stdio(false);
    while(cin>>N>>M>>K){
        cin.tie(0);
        fill(v[0],v[0]+NODE_NUM*NODE_NUM,0);
        for(int i=0;i<M;i++){
            int city1,city2;
            //scanf("%d%d",&city1,&city2);
            cin>>city1>>city2; 
            v[city1][city2] = v[city2][city1] = 1;
        } 

        for(int i=0;i<K;i++){
            int count = 0;
            fill(visited,visited+NODE_NUM,false);
            int city;
            cin>>city;
            visited[city] = true;
            for(int j = 1;j<=N;j++){
                if(visited[j]==false){
                    dfs(j);
                    count++;
                }
            }
            cout<<count-1<<endl;
        }
    } 
    return 0;
} 
