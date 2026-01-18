#include <iostream>
using namespace std;

typedef struct Node{
    Node *pLeft;
    Node *pRight;
    int data;
} *Tree;

void initTree(Tree &T){
    T = nullptr;
}

Node* createNode (int x){
    Node *p = new Node;
    p->pLeft = p->pRight = nullptr;
    p->data = x;
    return p;
}

void insertNode (Node *p, Tree &T){
    if (T == nullptr)
        T = p;
    else{
        if (p->data < T->data)
            insertNode(p, T->pLeft);
        else if (p->data > T->data)
            insertNode(p, T->pRight);
        else
            delete p; // tránh leak bộ nhớ nếu trùng
    }
}

void inputValue(Tree &T){
    int choice;
    do{
        int x;
        cout << "\nEnter value: ";
        cin >> x;
        Node *p = createNode(x);
        insertNode(p, T);
        cout << "Continue? (1 - Yes, 0 - No): ";
        cin >> choice;
    }while (choice == 1);
}

void outputTree(Tree T){
    if (T != nullptr){
        outputTree(T->pLeft);
        cout << T->data << " ";
        outputTree(T->pRight);
    }
}

void SumTree(Tree T, int &sum){
    if (T != nullptr){
        sum += T->data;
        SumTree(T->pLeft, sum);
        SumTree(T->pRight, sum);
    }
}

int main (){
    Tree T = nullptr;
    inputValue(T);

    if (T == nullptr){
        cout << "\nTree is empty!";
        return 0;
    }

    cout << "\nThe tree in-order is: ";
    outputTree(T);

    int sum = 0;
    SumTree(T, sum);
    cout << "\nSum of all nodes in tree: " << sum << endl;

    return 0;
}
