/*#include <iostream>

#define LH -1 // Left heavy
#define EH 0  // Even height
#define RH 1  // Right heavy

using namespace std;

typedef struct AVLNode {
    int bal;      // Balance factor
    int data;
    AVLNode* pLeft;
    AVLNode* pRight;
} *Tree;

void rotateLL(Tree& T) {
    Tree p = T->pLeft;
    T->pLeft = p->pRight;
    p->pRight = T;
    switch (p->bal) {
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

void rotateRR(Tree& T) {
    AVLNode* p = T->pRight;
    T->pRight = p->pLeft;
    p->pLeft = T;
    switch (p->bal) {
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

void rotateLR(Tree& T) {
    AVLNode* p = T->pLeft;
    AVLNode* q = p->pRight;
    T->pLeft = q->pRight;
    q->pRight = T;
    p->pRight = q->pLeft;
    q->pLeft = p;
    switch (q->bal) {
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

void rotateRL(Tree& T) {
    AVLNode* p = T->pRight;
    AVLNode* q = p->pLeft;
    T->pRight = q->pLeft;
    q->pLeft = T;
    p->pLeft = q->pRight;
    q->pRight = p;
    switch (q->bal) {
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

int balanceLeft(Tree& T) {
    AVLNode* p = T->pLeft;
    switch (p->bal) {
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
    return 0; // Should not reach here, but for completeness
}

int balanceRight(Tree& T) {
    AVLNode* p = T->pRight;
    switch (p->bal) {
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
    return 0; // Should not reach here, but for completeness
}

int insertNode(Tree& T, int x) {
    int res;
    if (T) {
        if (T->data == x) return 0; // Duplicate
        if (T->data > x) {
            res = insertNode(T->pLeft, x);
            if (res < 2) return res;
            switch (T->bal) {
                case RH:
                    T->bal = EH;
                    return 1;
                case EH:
                    T->bal = LH;
                    return 2;
                case LH:
                    return balanceLeft(T);
            }
        } else {
            res = insertNode(T->pRight, x);
            if (res < 2) return res;
            switch (T->bal) {
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
    if (T == nullptr) return -1; // Memory allocation failed
    T->data = x;
    T->bal = EH;
    T->pLeft = T->pRight = nullptr;
    return 2;
}

void createTree(Tree& T) {
    bool choice = true;
    while (choice) {
        int x;
        cout << "Enter value (or enter non-number to skip): ";
        if (!(cin >> x)) {
            // Handle bad input
            cout << "Invalid input! Please enter an integer." << endl;
            cin.clear(); // Clear fail state
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Ignore bad input
            continue;
        }
        int res = insertNode(T, x);
        if (res == -1)
            cout << "Process failed (memory allocation)!" << endl;
        else if (res == 0)
            cout << "Value already exists!" << endl;
        else
            cout << "Value inserted!" << endl;

        cout << "Continue? (1 - Yes, 0 - No): ";
        int a;
        if (!(cin >> a)) {
            cout << "Invalid input! Assuming no." << endl;
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            choice = false;
        } else if (a == 0) {
            choice = false;
        }
    }
}

void Traverse(Tree T) {
    if (T != nullptr) {
        Traverse(T->pLeft);
        cout << T->data << " ";
        Traverse(T->pRight);
    }
}

void removeAll(Tree& T) {
    if (T != nullptr) {
        removeAll(T->pLeft);
        removeAll(T->pRight);
        delete T;
        T = nullptr;
    }
}

void findKey(Tree T, int key) {
    if (T == nullptr) {
        cout << "Value does not exist in tree!" << endl;
        return;
    }
    if (T->data == key) {
        cout << key << " exists in tree!" << endl;
        return;
    }
    if (T->data > key)
        findKey(T->pLeft, key);
    else
        findKey(T->pRight, key);
}

int main() {
    Tree T = nullptr;
    createTree(T);
    cout << "Tree has been created." << endl;

    int key;
    cout << "Enter key to find: ";
    if (!(cin >> key)) {
        cout << "Invalid input! Skipping search." << endl;
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    } else {
        findKey(T, key);
    }

    cout << "In-order traversal: ";
    Traverse(T);
    cout << endl;

    removeAll(T);
    return 0;
}
    */