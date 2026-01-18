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


void CreateTree(const char* filename, Tree &T) {
    InitTree(T);
    ifstream file(filename);
    if (!file) {
        cout << "Can't open file!\n";
        return;
    }

    int x;
    while (file >> x) {
        InsertNode(T, x);
    }

    file.close();
}

void PrintLevK(Tree T, int k) {
    if (T == NULL || k < 0) return;

    queue<Tree> q;
    q.push(T);
    int level = 0;

    while (!q.empty()) {
        int levelSize = q.size();

        if (level == k) {
            for (int i = 0; i < levelSize; i++) {
                Tree node = q.front();
                q.pop();
                cout << node->data << " ";

            }
            return;
        }

        for (int i = 0; i < levelSize; i++) {
            Tree node = q.front();
            q.pop();

            if (node->pL) q.push(node->pL);
            if (node->pR) q.push(node->pR);
        }

        level++;
    }
}

int main(){
    char fileName[] = "T1.txt"; Tree T; int k = 3;
    CreateTree(fileName,T);
    PrintLevK (T, k);
    return 0;
}