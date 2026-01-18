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

int maxEvenValue = -1;
Tree maxEvenNode = NULL;

void FindMaxEvenNode(Tree T) {
    if (!T) return;

    if (T->data % 2 == 0 && T->data > maxEvenValue) {
        maxEvenValue = T->data;
        maxEvenNode = T;
    }

    FindMaxEvenNode(T->pL);
    FindMaxEvenNode(T->pR);
}

bool FindPath(Tree T, Tree target, vector<int> &path) {
    if (!T) return false;

    path.push_back(T->data);

    if (T == target)
        return true;

    if ((T->pL && FindPath(T->pL, target, path)) ||
        (T->pR && FindPath(T->pR, target, path)))
        return true;

    path.pop_back();
    return false;
}

void PathMaxEven(Tree T) {
    maxEvenValue = -1;
    maxEvenNode = NULL;

    FindMaxEvenNode(T);

    if (maxEvenNode == NULL) return;

    vector<int> path;
    FindPath(T, maxEvenNode, path);

    for (size_t i = 0; i < path.size(); i++) {
    if (i != path.size() - 1)
        cout << path[i] << " -> ";
    else
        cout << path[i];
}

    cout << endl;
}

int main (){
    char fileName[] = "T1.txt"; Tree T;
    CreateTree(fileName,T);
    PathMaxEven (T);
    return 0;
}