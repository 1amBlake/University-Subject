#include <iostream>

#define LH -1 // R<L
#define EH 0 // R=L
#define RH 1 // R>L

using namespace std;

typedef struct AVLNode{
    int bal; // balance factor - chi so can bang
    int data;
    AVLNode *pLeft;
    AVLNode *pRight;
} *Tree;

void rotateLL (Tree &T){
    Tree p = T->pLeft;
    T->pLeft = p->pRight;
    p->pRight = T;
    switch (p->bal)
    {
    case LH:
        T->bal = EH;
        p->bal = EH;
        break;
    case EH:
        T->bal = LH;
        p->bal = RH;
        break;
    }
    T = p;
}

void rotateRR (Tree &T){
    AVLNode *p = T->pRight;
    T->pRight = p->pLeft;
    p->pLeft = T;
    switch(p->bal){
        case RH:
            T->bal = EH;
            p->bal = EH;
            break;
        case EH:
            T->bal = RH;
            p->bal = LH;
            break;
    }
    T = p;
}

void rotateLR (Tree &T){
    AVLNode* p = T->pLeft;
    AVLNode* q = p->pRight;
    T->pLeft = q->pRight;
    q->pRight = T;
    p->pRight = q->pLeft;
    q->pLeft = p;
    switch(q->bal){
        case LH:
            T->bal = RH;
            p->bal = EH;
            break;
        case EH:
            T->bal = EH;
            p->bal = EH;
            break;
        case RH:
            T->bal = EH;
            p->bal = LH;
            break;
    }
    q->bal = EH;
    T = q;
}

void rotateRL (Tree &T){
    AVLNode *p = T->pRight;
    AVLNode *q = p->pLeft;
    T->pRight = q->pLeft;
    q->pLeft = T;
    p->pLeft = q->pRight;
    q->pRight = p;
    switch(q->bal){
        case RH:
            T->bal = LH;
            p->bal = EH;
            break;
        case EH:
            T->bal = EH;
            p->bal = EH;
            break;
        case LH:
            T->bal = EH;
            p->bal = RH;
            break; 
    }
    q->bal = EH;
    T = q;
}

int balanceLeft (Tree &T){
    AVLNode *p = T->pLeft;
    switch(p->bal){
        case LH:
            rotateLL(T);
            return 2;
        case EH:
            rotateLL(T);
            return 1;
        case RH:
            rotateLR(T);
            return 2;
    }
}

int balanceRight (Tree &T){
    AVLNode *p = T->pRight;
    switch(p->bal){
        case RH:
            rotateRR(T);
            return 2;
        case EH:
            rotateRR(T);
            return 1;
        case LH:
            rotateRL(T);
            return 2;
    }
}

int insertNode (Tree &T, int x){
    int res;
    if (T){
        if (T->data == x)
            return 0;
        else if (T->data > x){
            res = insertNode(T->pLeft, x);
            if (res < 2)
                return res;
            switch(T->bal){
                case RH:
                    T->bal = EH;
                    return 1;
                case EH:
                    T->bal = LH;
                    return 2;
                case LH:
                    return balanceLeft(T);
            }
        }
        else{
                res = insertNode(T->pRight, x);
                if(res < 2)
                    return res;
                    switch(T->bal){
                        case LH:
                            T->bal = EH;
                            return 1;
                        case EH:
                            T->bal = RH;
                            return 2;
                        case RH:
                            return balanceRight(T);
                    }
            }
    }
    T = new AVLNode;
    if (T == nullptr)
        return -1;
    T->data = x;
    T->bal = EH;
    T->pLeft = T->pRight = nullptr;
    return 2;
}

void createTree (Tree &T){
    double choice = true;
    do{
        int x;
        cout << "Enter value: ";
        cin >> x;
        int res = insertNode(T, x);
        if (res ==  -1)
            cout << "Process failed!" << endl;
        else if (res == 0)
            cout << "Value has existed!" << endl;
        else
            cout << "Value inserted!" << endl;
        cout << "Continue? (1 - Yes, 0 - No): ";
        int a;
        cin >> a;
        if (a == 0)
            choice = false;
    }while (choice == true);
}

void Traverse(Tree T){
    if (T != nullptr){
        Traverse(T->pLeft);
        cout << T->data << " ";
        Traverse(T->pRight);
    }
}

void removeAll (Tree &T){
if (T != nullptr){
    removeAll(T->pLeft);
    removeAll(T->pRight);
    delete T;
    }
}

void findKey(Tree T, int key){
    if (T == nullptr){
        cout << "Value not existed in tree!" << endl;
        return;
    }
    if (T->data == key){
        cout << key << " existed in tree!" << endl;
        return; 
    }
    if (T->data > key)
        findKey(T->pLeft, key);
    else
        findKey(T->pRight, key);
}

int main(){
    AVLNode *T = nullptr;
    createTree(T);
    cout << "Tree has been created: ";
    cout << endl;
    int key;
    cout << "Enter key to find: ";
    cin >> key;
    findKey(T, key);
    Traverse(T);
    removeAll(T);   
    return 0;
}

/*
2/ 10 insert 30 insert 35 insert 32 insert 20 insert 8 insert 30 exists 40 insert 50 insert -10 insert -5 insert
3/ -10 -5 8 10 20 30 31 35 40 50
    vi tri can bang sau moi lan insert
5/ -5 7 10 15 20 30 35 50 55 57 65
6/            20
             /   \
           10     55
          / \    /  \
        -5  15  35  57
        /      /  \   \
       7      30   50  65

*/