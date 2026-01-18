#include <iostream>
#include <cstring>
#include <cctype>
#include <iomanip>
using namespace std;

struct item {
    char masv[20];
    char name[20];
    double diem;
};

typedef struct Node{
    item key;
    Node *pLeft;
    Node *pRight;
} *Tree;

void initTree(Tree &T){
    T = nullptr;
}

Node* createNode(item sv){
    Node *p = new Node;
    p->key = sv;
    p->pLeft = p->pRight = nullptr;
    return p;
}

bool insertNode(Tree &T, item sv){
    if (T == nullptr){
        T = createNode(sv);
        return true;
    }
    int cmp = strcmp(sv.masv, T->key.masv);

    if (cmp == 0) return false;
    else if (cmp < 0) return insertNode(T->pLeft, sv);
    else return insertNode(T->pRight, sv);
}

void NhapSV(item &SV){
    cout << "Enter student ID: ";
    cin >> SV.masv;
    cin.ignore();
    
    bool chk;
    do{
        chk = true;
        cout << "Enter student name: ";
        cin.getline(SV.name, 20);
        for(int i = 0; SV.name[i] != '\0'; i++){
            if(!isalpha(SV.name[i]) && SV.name[i] != ' '){
                cout << "Invalid name! Try again.\n";
                chk = false;
                break;
            }
        }
    } while(!chk);

    do{
        chk = true;
        cout << "Enter student score: ";
        cin >> SV.diem;
        if (SV.diem < 0 || SV.diem > 10){
            cout << "Score must be 0-10!\n";
            chk = false;
        }
    } while(!chk);
}

void createTree(Tree &T){
    initTree(T);
    int cont;
    do{
        item sv;
        NhapSV(sv);
        while(!insertNode(T, sv)){
            cout << "Duplicate Student ID! Enter again.\n";
            NhapSV(sv);
        }
        cout << "Add another? (1-Yes | 0-No): ";
        cin >> cont;
        cin.ignore();
    }while(cont == 1);
}

void outputTree(Tree T){
    if(T != nullptr){
        outputTree(T->pLeft);
        cout << "|" << setw(20) << T->key.masv
             << "|" << setw(20) << T->key.name
             << "|" << setw(6) << T->key.diem << "|\n";
        outputTree(T->pRight);
    }
}

void countNode(Tree T, int &count){
    if(T == nullptr) return;
    count++;
    countNode(T->pLeft, count);
    countNode(T->pRight, count);
}

int heightOfTree(Tree T){
    if(T == nullptr) return -1;
    return max(heightOfTree(T->pLeft), heightOfTree(T->pRight)) + 1;
}

Node* searchNode(Tree T, char ID[]){
    if(T == nullptr) return nullptr;
    int cmp = strcmp(ID, T->key.masv);
    if(cmp == 0) return T;
    if(cmp < 0) return searchNode(T->pLeft, ID);
    return searchNode(T->pRight, ID);
}

void searchStandFor(Tree &replace, Tree &delNode){
    if(delNode->pLeft != nullptr)
        searchStandFor(replace, delNode->pLeft);
    else{
        replace->key = delNode->key;
        replace = delNode;
        delNode = delNode->pRight;
    }
}

void delStudentID(Tree &T, char ID[]){
    if(T == nullptr) return;

    if(strcmp(ID, T->key.masv) < 0)
        delStudentID(T->pLeft, ID);
    else if(strcmp(ID, T->key.masv) > 0)
        delStudentID(T->pRight, ID);
    else {
        Node *p = T;
        if(T->pLeft == nullptr)
            T = T->pRight;
        else if(T->pRight == nullptr)
            T = T->pLeft;
        else{
            searchStandFor(p, T->pRight);
        }
        delete p;
        cout << "Deleted successfully!\n";
    }
}

int main(){
    Tree T = nullptr;
    int choice;

    do{
        cout << "\n===== MENU =====\n";
        cout << "1. Create Tree\n";
        cout << "2. Display Tree (LNR)\n";
        cout << "3. Count Nodes\n";
        cout << "4. Tree Height\n";
        cout << "5. Find Student by ID\n";
        cout << "6. Delete Student by ID\n";
        cout << "0. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;
        cin.ignore();

        switch(choice){
            case 1: createTree(T); break;
            case 2:
                cout << "|" << setw(20) << "ID" << "|" << setw(20)
                     << "Name" << "|" << setw(6) << "Score" << "|\n";
                outputTree(T);
                break;
            case 3:{
                int count = 0;
                countNode(T, count);
                cout << "Number of nodes: " << count << endl;
                break;
            }
            case 4:
                cout << "Height of tree: " << heightOfTree(T) << endl;
                break;
            case 5:{
                char id[20];
                cout << "Enter ID to find: ";
                cin >> id;
                Node *res = searchNode(T, id);
                if(res != nullptr){
                    cout << "|" << setw(20) << res->key.masv
                         << "|" << setw(20) << res->key.name
                         << "|" << setw(6) << res->key.diem << "|\n";
                } else cout << "Not found!\n";
                break;
            }
            case 6:{
                char id[20];
                cout << "Enter ID to delete: ";
                cin >> id;
                delStudentID(T, id);
                break;
            }
        }
    } while(choice != 0);

    return 0;
}
