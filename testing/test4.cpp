#include <iostream>

int insertNode(AVLTree &T, DataType X){
    int res;
    if(T){
        if (T->key==X) //đã có
            return 0;
        if (T->key > X){
            res = insertNode(T->pLeft, X);
            if (res < 2)
                return res;
            switch(T->balFactor){
                case RH:
                    T->balFactor = EH;
                    return 1;
                case EH:
                    T->balFactor = LH;
                    return 2;
                case LH:
                    balanceLeft(T);
                    return 1;
            }
        }
    }
    else { //T->key < X
        res = insertNode(T->pRight, X);
        if (res < 2)
            return res;
        switch(T->balFactor){
            case LH:
                T->balFactor = EH;
                return 1;
            case EH:
                T->balFactor = RH;
                return 2;
            case RH:
                balanceRight(T);
                return 1;
    }
    T = new TNode;
    if(T == NULL)
        return -1; //không đủ bộ nhớ
    T->key = X;
    T->balFactor = EH;
    T->pLeft = T->pRight = NULL;
    return 2;
}