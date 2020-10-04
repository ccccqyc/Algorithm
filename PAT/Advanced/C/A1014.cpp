#include <cstdio>
#include <queue>
#include <algorithm>
#include <iostream>
using namespace std;

/*小时转换分钟函数,归一处理*/
int hh2mm(int h, int m)
{
    return h*60+m;
}
struct Window
{
    /* 窗口当前队伍的最后服务时间/队首客户服务结束时间*/
    int endTime=hh2mm(8, 0), popTime=endTime;
    queue<int> q;
} window[20];

int main()
{
    int n, m, k, query_num, q_ele;
    scanf("%d%d%d%d",&n,&m,&k,&query_num);
    /*服务结束时间, 耗费时间*/
    int finishTimes[k], dualTimes[k];
    /*读入服务需要时间*/
    for(int i=0; i<k; i++) scanf("%d", &dualTimes[i]);

    /* 循环入队 */
    int inx = 0;
    for(int i=0; i<min(n*m, k); i++)
    {
        window[inx%n].q.push(inx);
        /* 更细窗口结束时间 */
        window[inx%n].endTime += dualTimes[inx];
        /* 更新首个客户的完成时间 */
        if(inx<n) window[inx].popTime = dualTimes[inx];
        /* 当前入队客户服务结束时间保存为答案 */
        finishTimes[inx] = window[inx%n].endTime;
        inx++;
    }
    /* 记录窗口队列中下标元素*/
//    queue<int> q0 = window[0].q, q1=window[1].q;
    /* 剩余客户入队 */
    for(; inx < k; inx++)
    {
        int idx = -1, minPopTime = 1 << 30;
        /* 寻找所有窗口最小poptime */
        for(int i=0; i<n; i++)
        {
            if(window[i].popTime < minPopTime)
            {
                idx = i;
                minPopTime = window[i].popTime;

            }
        }
        /* 引用, 下文中用W代替window[idx],行文清晰 */
        /* 不断弹出所有窗口中，耗时最短的首元素，并将后续元素入队 */
        Window& W = window[idx];
        /* push存储窗口队列中下标元素*/
//        if(idx==0) q0.push(inx);
//        else q1.push(inx);

        W.q.pop();
        W.q.push(inx);
        /* 更新该窗口队列的endTime(累计和) */
        W.endTime += dualTimes[inx];
        /* 更新该窗口的popTime(队首元素) */
        W.popTime += dualTimes[W.q.front()];
        /* 客户inx服务结束时间为该窗口endTime */
        finishTimes[inx] = W.endTime;
    }

    /* // 分别打印窗口队列中下标 */
//    int q00 = q0.size(),q11 = q1.size();
//    for(int i=0; i<q00; i++)
//    {
//       printf("%d+", q0.front());
//       q0.pop();
//    }
//    cout << endl;
//    for(int i=0; i<q11; i++)
//    {
//       printf("%d+", q1.front());
//       q1.pop();
//    }
//    cout << endl;


    /* 查询客户编号 */
    for(int i=0; i< query_num; i++)
    {
        scanf("%d", &q_ele);
        /* 服务开始时间达到17:00, 输出sorry*/
        if(finishTimes[q_ele-1] - dualTimes[q_ele-1] >= hh2mm(17, 0))
            printf("Sorry");
        /* 否则输出服务结束时间 */
        else
            printf("%02d:%02d", finishTimes[q_ele-1]/60, finishTimes[q_ele-1]%60);
        if(i<query_num-1) printf("\n");
    }
}

