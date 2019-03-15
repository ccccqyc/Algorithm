#include <stdio.h>
#include <stdlib.h>

typedef char ElementType;
typedef struct TNode *Position;
typedef Position BinTree;
struct TNode {
    ElementType Data;
    BinTree Left;
    BinTree Right;
};

BinTree CreatBinTree(); /* 实现细节忽略 */

int GetHeight(BinTree BT);

BinTree CreatBinTree() { //层序生成二叉树
    //特殊限制，输入为0的时候为叶节点
    BinTree BT;
    ElementType T;
    int front = 0, tail = 0;
    BinTree Queue[1001] = {'\0'}; //父节点数列
    BinTree Date;
    scanf("%c", &T);
    if (T == '0') //空树
        return NULL;
    else {
        BT = (BinTree)malloc(sizeof(struct TNode));
        if (BT == NULL)
            return NULL;
        BT->Data = T;                //根节点赋值
        BT->Left = BT->Right = NULL; //初始化左右子树
        Queue[tail++] = BT;
    }
    while (Queue[front] != NULL) { //根节点入队列
        Date = Queue[front++];
        scanf("%c", &T);
        if (T == '0')
            Date->Left = NULL;
        else {
            Date->Left = (BinTree)malloc(sizeof(struct TNode));
            if (Date->Left == NULL) //先完成左树的操作，然后完成右树的操作
                return NULL;
            Date->Left->Data = T;
            Date->Left->Left = Date->Left->Right = NULL;
            Queue[tail++] = Date->Left;
        }
        scanf("%c", &T);
        if (T == '0')
            Date->Right = NULL;
        else {
            Date->Right = (BinTree)malloc(sizeof(struct TNode));
            if (Date->Right == NULL)
                return NULL;
            Date->Right->Data = T;
            Date->Right->Left = Date->Right->Right = NULL;
            Queue[tail++] = Date->Right;
        }
    };

    return BT;
}

int main() {
    BinTree BT = CreatBinTree();
    printf("%d\n", GetHeight(BT));
    return 0;
}
//递归写法
int GetHeight(BinTree BT) {
    int LH, RH;
    if (!BT) {
        return 0;
    } else {
        LH = GetHeight(BT->Left);
        RH = GetHeight(BT->Right);

        return LH > RH ? ++LH : ++RH;
    }
}