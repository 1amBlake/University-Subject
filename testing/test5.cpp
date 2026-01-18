int delNode(AVLTree &T, DataType X){
    int res;
    if(T==NULL) 
        return 0;
    if(T->key > X){
        res = delNode (T->pLeft, X);
        if(res < 2) 
            return res;
        switch(T->balFactor){ 
            case LH: 
                T->balFactor = EH;
                return 2;
            case EH: 
                T->balFactor = RH; 
                return 1;
            case RH: 
                return balanceRight(T);
        }
    } // if(T->key > X)
    if(T->key < X){
        res = delNode (T->pRight, X);
        if(res < 2)
            return res;
        switch(T->balFactor){ 
            case RH: 
                T->balFactor = EH; 
                return 2;
            case EH:
                T->balFactor = LH; 
                return 1;
            case LH: 
                return balanceLeft(T);
        }
    } // if(T->key == X)
    else{  //T->key == X
        AVLNode* p = T;
        if(T->pLeft == NULL) {
                T = T->pRight;
                res = 2; 
        }
        else if(T->pRight == NULL) { 
            T = T->pLeft; 
                res = 2; 
        }
        else{ //T có đủ cả 2 con 
            res = searchStandFor(p,T->pRight);
            if(res < 2) 
                return res;
            switch(T->balFactor){ 
                case RH: 
                    T->balFactor = EH; 
                    return 2;
                case EH: 
                    T->balFactor = LH; 
                    return 1;
                case LH: 
                    return balanceLeft(T);
            }
        }
        delete p;
        return res;
    }

}

int searchStandFor(AVLTree &p, AVLTree &q)
//Tìm phần tử thế mạng
{ int res;
if(q->pLeft)
{ res = searchStandFor(p, q->pLeft);
if(res < 2) return res;
switch(q->balFactor)
{ case LH: q->balFactor = EH; return 2;
case EH: q->balFactor = RH; return 1;
case RH: return balanceRight(T);
}
} else
{ p->key = q->key; p = q; q = q->pRight; return 2;
}
}