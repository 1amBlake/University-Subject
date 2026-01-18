#include <iostream>
#include <fstream>
#include <queue>
using namespace std;

struct TNode {
    int data;
    TNode *pL, *pR;
};
typedef TNode* Tree;

void InitTree(Tree &T) {
    T = NULL;
}

TNode* CreateNode(int x) {
    TNode* p = new TNode;
    p->data = x;
    p->pL = p->pR = NULL;
    return p;
}

void InsertNode(Tree &T, int x) {
    if (T == NULL) {
        T = CreateNode(x);
        return;
    }
    if (x < T->data)
        InsertNode(T->pL, x);
    else if (x > T->data)
        InsertNode(T->pR, x);
}

void CreateTree(const char* FileName, Tree &T) {
    InitTree(T);
    ifstream file(FileName);
    if (!file) return;
    int x;
    while (file >> x) {
        InsertNode(T, x);
    }
    file.close();
}
int maxEven = -1;
int levelMax = -1;
int degreeMax = -1;

void FindMaxEven(Tree T, int level) {
    if (!T) return;

    if (T->data % 2 == 0 && T->data > maxEven) {
        maxEven = T->data;
        levelMax = level;
        degreeMax = (T->pL != NULL) + (T->pR != NULL); 
    }

    FindMaxEven(T->pL, level + 1);
    FindMaxEven(T->pR, level + 1);
}

void InfoMaxEven(Tree T) {
    maxEven = -1; levelMax = -1; degreeMax = -1;
    FindMaxEven(T, 0);

    cout << "MaxEven = " << maxEven << endl;
    if (maxEven != -1) {
        cout << "Level = " << levelMax << " , Degree = " << degreeMax << endl;
    }
}

int main(){
    char fileName[] = "T1.txt"; Tree T;
    CreateTree(fileName,T);
    InfoMaxEven(T);
    return 0;
}