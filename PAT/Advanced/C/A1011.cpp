#include<cstdio>
 int main(){
 	char S[3] = {'W','T','L'};

    double ans = 1.0, tmp, a;
    int idx;                        //��¼ÿ��������ֵ��±�
    for(int i = 0; i < 3; i++){
        tmp = 0.0;
        for(int j = 0; j < 3; j++){ //Ѱ�Ҹ����������ִ��� tmp
            scanf("%lf", &a);
            if(a > tmp){
                tmp = a;
                idx = j;
            } 
        }
        ans *= tmp;                 //����ʽ�۳�
        printf("%c ",S[idx]);       //�����Ӧ�ı������ 
    } 
    printf("%.2f", (ans * 0.65 - 1) * 2);   //����������
    return 0; 
 }
