#include <iostream>

struct Node {
    float heSo;
    int soMu;
    Node* link;
};

struct List {
    Node* first;
    Node* last;
};

void init(List &l) {
    l.first = NULL;
    l.last = NULL;
}

Node* GetNode(float hs, int sm) {
    Node* p = new Node;
    if (p == NULL)
        return NULL;
    p->heSo = hs;
    p->soMu = sm;
    p->link = NULL;
    return p;
}

void InterchangeSort(struct List *l) {
    struct Node *p, *q;
    for (p = l->first; p != NULL; p = p->link) {
        for (q = p->link; q != NULL; q = q->link) {
            if (p->soMu < q->soMu) {
                float tempHs = p->heSo;
                int tempSm = p->soMu;
                p->heSo = q->heSo;
                p->soMu = q->soMu;
                q->heSo = tempHs;
                q->soMu = tempSm;
            }
        }
    }
}


void AddLast(List &l, Node* new_ele) {
    if (l.first == NULL) {
        l.first = new_ele;
        l.last = l.first;
    } else {
        l.last->link = new_ele;
        l.last = new_ele;
    }
}

void InsertLast(List &l, float hs, int sm) {
    Node* new_ele = GetNode(hs, sm);
    if (new_ele == NULL)
        return;
    AddLast(l, new_ele);
}

void NhapDaThuc(List &l) {
    float hs;
    int sm;
    do {
        std::cout << "Nhap he so (nhap 0 de ket thuc): ";
        std::cin >> hs;
        if (hs == 0)
            break;
        std::cout << "Nhap so mu: ";
        std::cin >> sm;
        InsertLast(l, hs, sm);
    } while (hs != 0);
    std::cout << "Nhap ket thuc\n";
}

void XuatDanhSach(List l) {
    Node* p = l.first;
    std::cout << "\nDa thuc: ";
    while (p != NULL) {
        if (p != l.first && p->heSo > 0)
            std::cout << "+";
        std::cout << p->heSo << "x^" << p->soMu << " ";
        p = p->link;
    }
    std::cout << "\n";
}

void CongDaThuc(List l1, List l2, List &l3) {
    Node* p1 = l1.first;
    Node* p2 = l2.first;
    float tongHeSo;
    while (p1 && p2){
        if(p1->soMu == p2->soMu){
            tongHeSo = p1->heSo + p2->heSo;
            if(tongHeSo != 0)
                InsertLast(l3, tongHeSo, p1->soMu);
            p1 = p1->link;
            p2 = p2->link;
        }
        else{
            if(p1->soMu > p2->soMu){
                InsertLast(l3, p1->heSo, p1->soMu);
                p1 = p1->link;
            }
            else{
                InsertLast(l3, p2->heSo, p2->soMu);
                p2 = p2->link;
            }
        }
    }
    while(p1){
        InsertLast(l3, p1->heSo, p1->soMu);
        p1 = p1->link;
    }
    while(p2){
        InsertLast(l3, p2->heSo, p2->soMu);
        p2 = p2->link;
    }
}

int main() {
    List daThuc1, daThuc2, daThucTong;
    init(daThuc1);
    init(daThuc2);
    init(daThucTong);

    std::cout << "Nhap da thuc thu nhat:\n";
    NhapDaThuc(daThuc1);
    XuatDanhSach(daThuc1);

    std::cout << "Nhap da thuc thu hai:\n";
    NhapDaThuc(daThuc2);
    XuatDanhSach(daThuc2);

    CongDaThuc(daThuc1, daThuc2, daThucTong);
    std::cout << "Da thuc tong:\n";
    XuatDanhSach(daThucTong);

    return 0;
}