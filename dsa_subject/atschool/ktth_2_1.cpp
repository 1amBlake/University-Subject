#include <iostream>
#include <fstream>

using namespace std;
struct TNode 
{  int data;
   TNode *pL, *pR;
};
typedef TNode* Tree;

TNode * createNode(int x){
    TNode *p = new TNode;
    p->data =  x;
    p->pL = p->pR = nullptr;
    return p;
}

void insertNode (Tree &T, int x){
    if (T == nullptr)
        T = createNode(x);
    else if (x < T -> data)
        insertNode(T->pL, x);
    else if (x > T -> data)
        insertNode(T->pR, x);
}

void NLR(Tree T){
    if (T != nullptr){
        cout << T->data << " ";
        NLR(T->pL);
        NLR(T->pR);
    }
}

void LNR(Tree T){
    if (T != nullptr){
        LNR(T->pL);
        cout << T->data << " ";
        LNR(T->pR);
    }
}

void LRN(Tree T){
    if (T!=nullptr){
        LRN(T->pL);
        LRN(T->pR);
        cout << T->data << " ";
    }
}

void CreateTree (char FileName [], Tree &T)
{
    FILE * f = fopen(FileName, "r");
    if (f == nullptr)
        return;
    T = nullptr;
    int x;
    while (fscanf(f, "%d", &x) == 1){
        insertNode(T, x);
    }
    fclose(f);
    
    cout << "NLR : ";
    NLR(T);
    cout << endl;
    cout << "LNR : ";
    LNR(T);
    cout << endl;
    cout << "LRN : ";
    LRN(T);
    cout << endl;
}

int main(){
    char fileName[] = "T1.txt"; Tree T; 
    CreateTree(fileName,T);
    return 0;
}