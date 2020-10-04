#include <cstdio>
#include <queue>
#include <algorithm>
#include <iostream>
using namespace std;

/*Сʱת�����Ӻ���,��һ����*/
int hh2mm(int h, int m)
{
    return h*60+m;
}
struct Window
{
    /* ���ڵ�ǰ�����������ʱ��/���׿ͻ��������ʱ��*/
    int endTime=hh2mm(8, 0), popTime=endTime;
    queue<int> q;
} window[20];

int main()
{
    int n, m, k, query_num, q_ele;
    scanf("%d%d%d%d",&n,&m,&k,&query_num);
    /*�������ʱ��, �ķ�ʱ��*/
    int finishTimes[k], dualTimes[k];
    /*���������Ҫʱ��*/
    for(int i=0; i<k; i++) scanf("%d", &dualTimes[i]);

    /* ѭ����� */
    int inx = 0;
    for(int i=0; i<min(n*m, k); i++)
    {
        window[inx%n].q.push(inx);
        /* ��ϸ���ڽ���ʱ�� */
        window[inx%n].endTime += dualTimes[inx];
        /* �����׸��ͻ������ʱ�� */
        if(inx<n) window[inx].popTime = dualTimes[inx];
        /* ��ǰ��ӿͻ��������ʱ�䱣��Ϊ�� */
        finishTimes[inx] = window[inx%n].endTime;
        inx++;
    }
    /* ��¼���ڶ������±�Ԫ��*/
//    queue<int> q0 = window[0].q, q1=window[1].q;
    /* ʣ��ͻ���� */
    for(; inx < k; inx++)
    {
        int idx = -1, minPopTime = 1 << 30;
        /* Ѱ�����д�����Сpoptime */
        for(int i=0; i<n; i++)
        {
            if(window[i].popTime < minPopTime)
            {
                idx = i;
                minPopTime = window[i].popTime;

            }
        }
        /* ����, ��������W����window[idx],�������� */
        /* ���ϵ������д����У���ʱ��̵���Ԫ�أ���������Ԫ����� */
        Window& W = window[idx];
        /* push�洢���ڶ������±�Ԫ��*/
//        if(idx==0) q0.push(inx);
//        else q1.push(inx);

        W.q.pop();
        W.q.push(inx);
        /* ���¸ô��ڶ��е�endTime(�ۼƺ�) */
        W.endTime += dualTimes[inx];
        /* ���¸ô��ڵ�popTime(����Ԫ��) */
        W.popTime += dualTimes[W.q.front()];
        /* �ͻ�inx�������ʱ��Ϊ�ô���endTime */
        finishTimes[inx] = W.endTime;
    }

    /* // �ֱ��ӡ���ڶ������±� */
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


    /* ��ѯ�ͻ���� */
    for(int i=0; i< query_num; i++)
    {
        scanf("%d", &q_ele);
        /* ����ʼʱ��ﵽ17:00, ���sorry*/
        if(finishTimes[q_ele-1] - dualTimes[q_ele-1] >= hh2mm(17, 0))
            printf("Sorry");
        /* ��������������ʱ�� */
        else
            printf("%02d:%02d", finishTimes[q_ele-1]/60, finishTimes[q_ele-1]%60);
        if(i<query_num-1) printf("\n");
    }
}

