#include <iostream>
#include <cstdint>

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
    if (p == nullptr){
        cout << "cant create node" << endl;
        return nullptr;
    }
    p->pLeft = p->pRight = nullptr;
    p->data = x;
    return p;
}

void insertNode (Node *p, Tree &T){
    if (T == nullptr) // empty tree
        T = p;
    else{ // non-empty tree
        if (p->data < T->data)
            insertNode(p, T->pLeft);
        else if (p->data > T->data)
            insertNode(p, T->pRight);
        else
            delete p; // duplicate value
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

void findMaxMin (Tree T, int &max, int &min){
    if (T == nullptr)
        return;
    if (T->data > max)
        max = T->data;
    if (T->data < min)
        min = T->data;
    findMaxMin (T->pLeft, max, min);
    findMaxMin (T->pRight, max, min);
}

void countNodeTree (Tree T, int &count){
	if (T == nullptr){
		return;
	}
	count++;
	countNodeTree(T->pLeft, count);
	countNodeTree(T->pRight, count);
}

void countNodeLeaves(Tree T, int &count){
	if (T == nullptr)
		return;
	if (T->pLeft == nullptr && T->pRight == nullptr)
		count++;
	countNodeLeaves (T->pLeft, count);
	countNodeLeaves (T->pRight, count);
}	

int main (){
        Tree T = nullptr;
        inputValue(T);
		
        cout << "\nThe tree in-order is: ";
        outputTree(T);
      
		int sum = 0;
        SumTree(T, sum);
        cout << "\nSum of all nodes in tree: " << sum << endl;
		
		int max = INT32_MIN;
        int min = INT32_MAX;
        findMaxMin (T, max, min);
        cout << "\nMax value in tree: " << max << endl;
        cout << "Min value in tree: " << min << endl;
		
		int count = 0;
		countNodeTree(T, count);
		cout << "\nAmount of Node in tree is: " << count;
		
		count = 0;
		countNodeLeaves(T, count);
		cout << "\nAmount of Node Leaves in tree is: " << count;
        return 0;        
}