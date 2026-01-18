#include <iostream>
#include <iomanip>
#include <cstring>
using namespace std;

struct Ngay {
    int ngay, thang, nam;
};

struct SinhVien {
    char maSV[8];
    char hoTen[50];
    int gioiTinh;
    Ngay ngaySinh;
    char diaChi[100];
    char lop[12];
    char khoa[7];
};

struct Node {
    SinhVien data;
    Node* link;
};

struct List {
    Node* first;
    Node* last;
};

void Init(List &l) {
    l.first = nullptr;
    l.last = nullptr;
}

Node* GetNode(SinhVien x) {
    Node* p = new Node;
    if (p == nullptr) {
        cout << "Khong du bo nho de cap phat!\n";
        return nullptr;
    }
    p->data = x;
    p->link = nullptr;
    return p;
}

void AddLast(List &l, Node* p) {
    if (l.first == nullptr) {
        l.first = p;
        l.last = p;
    } else {
        l.last->link = p;
        l.last = p;
    }
}

void AddFirst(List &l, Node* p) {
    if (l.first == nullptr)
        l.first = l.last = p;
    else {
        p->link = l.first;
        l.first = p;
    }
}

Node* Search(List l, const char* maSV) {
    for (Node* p = l.first; p != nullptr; p = p->link) {
        if (strcmp(p->data.maSV, maSV) == 0)
            return p;
    }
    return nullptr;
}

int NhapSinhVien(SinhVien &x) {
    cout << "Nhap ma sinh vien (0 de dung): ";
    cin.getline(x.maSV, 8);
    if (strcmp(x.maSV, "0") == 0)
        return 0;

    cout << "Nhap ho ten: ";
    cin.getline(x.hoTen, 50);

    cout << "Nhap gioi tinh (0-Nu, 1-Nam): ";
    cin >> x.gioiTinh;

    cout << "Nhap ngay sinh (ngay thang nam): ";
    cin >> x.ngaySinh.ngay >> x.ngaySinh.thang >> x.ngaySinh.nam;
    cin.ignore();

    cout << "Nhap dia chi: ";
    cin.getline(x.diaChi, 100);

    cout << "Nhap lop: ";
    cin.getline(x.lop, 12);

    cout << "Nhap khoa: ";
    cin.getline(x.khoa, 7);

    return 1;
}

void InterchangeSortList(List &L) {
    for (Node *i = L.first; i != nullptr; i = i->link) {
        for (Node *j = i->link; j != nullptr; j = j->link) {
            if (strcmp(i->data.hoTen, j->data.hoTen) > 0) {
                swap(i->data, j->data);
            }
        }
    }
}

int InsertFirst_KhongTrung(List &L, SinhVien x) {
    if (Search(L, x.maSV)) {
        cout << "❌ Ma sinh vien da ton tai! Khong them vao danh sach.\n";
        return 0;
    }
    Node* p = GetNode(x);
    if (p == nullptr) return 0;
    AddFirst(L, p);
    return 1;
}

void NhapDSSV(List &l) {
    SinhVien x;
    cout << "=== Nhap danh sach sinh vien (Nhap maSV = 0 de dung) ===\n";
    while (true) {
        if (!NhapSinhVien(x))
            break;
        InsertFirst_KhongTrung(l, x);
        cout << "----------------------------------------\n";
    }
}

void XuatSinhVien(SinhVien x) {
    cout << left << setw(10) << x.maSV
         << " | " << setw(20) << x.hoTen
         << " | " << setw(3) << (x.gioiTinh ? "Nam" : "Nu")
         << " | " << setw(10)
         << (to_string(x.ngaySinh.ngay) + "/" +
             to_string(x.ngaySinh.thang) + "/" +
             to_string(x.ngaySinh.nam))
         << " | " << setw(30) << x.diaChi
         << " | " << setw(10) << x.lop
         << " | " << setw(5) << x.khoa
         << endl;
}

void XuatDSSV(List l) {
    cout << "\n=== DANH SACH SINH VIEN ===\n";
    cout << left << setw(10) << "MaSV"
         << " | " << setw(20) << "Ho Ten"
         << " | " << setw(3) << "GT"
         << " | " << setw(10) << "Ngay Sinh"
         << " | " << setw(30) << "Dia Chi"
         << " | " << setw(10) << "Lop"
         << " | " << setw(5) << "Khoa" << endl;
    cout << string(100, '-') << endl;

    for (Node* p = l.first; p != nullptr; p = p->link)
        XuatSinhVien(p->data);
}

int RemoveFirst(List &L) {
    if (L.first == nullptr) return 0;
    Node* p = L.first;
    L.first = p->link;
    if (L.first == nullptr)
        L.last = nullptr;
    delete p;
    return 1;
}

int RemoveAfter(List &L, Node *q) {
    if (q != nullptr && q->link != nullptr) {
        Node* p = q->link;
        q->link = p->link;
        if (p == L.last)
            L.last = q;
        delete p;
        return 1;
    }
    return 0;
}

Node* TimXoa(List L, const char x[]) {
    Node* p = L.first;
    while (p != nullptr && p->link != nullptr) {
        if (strcmp(p->link->data.maSV, x) == 0)
            return p;
        p = p->link;
    }
    return nullptr;
}

int RemoveX(List &L, const char x[]) {
    if (L.first == nullptr) return 0;

    if (strcmp(L.first->data.maSV, x) == 0) {
        RemoveFirst(L);
        return 1;
    }

    Node* q = TimXoa(L, x);
    if (q == nullptr) {
        cout << "Khong tim thay sinh vien co ma: " << x << endl;
        return 0;
    } else {
        RemoveAfter(L, q);
        return 1;
    }
}
void SListAppend(List &L, List &L2) {
    if (L2.first == nullptr) return;
    if (L.first == nullptr)
        L = L2;
    else {
        L.last->link = L2.first;
        L.last = L2.last;
    }
    Init(L2);
}
int main() {
    List l;
    Init(l);
    NhapDSSV(l);
    InterchangeSortList(l);
    XuatDSSV(l);

    char maXoa[8];
    cout << "\nNhap ma sinh vien can xoa: ";
    cin.getline(maXoa, 8);
    RemoveX(l, maXoa);

    cout << "\nDanh sach sau khi xoa:\n";
    XuatDSSV(l);

    return 0;
}

//QS
/*
void ListQSort(List&L) {
Node *X, *p;
List L1, L2;
if (L.first == L.last) return;
Init(L1); Init(L2);
X = L.first; L.first=x->link;
while (L.first != NULL) {
p = L.first;
if (p->data <= X->data) AddFirst(L1, p);
else AddFirst(L2, p);
}
ListQSort(L1);ListQSort(L2);
ListAppend(L, L1);
AddLast(L, X);
ListAppend(L, L2);
}

void QuickSort(list &l)
{
node *p, *x;
list l1, l2;
if (l.pHead == l.pTail)
return;
init(l1);
init(l2);
x = l.pHead;
l.pHead = x->pNext;
while (l.pHead != NULL)
{
p = l.pHead;
l.pHead = p->pNext;
p->pNext = NULL;
if (p->data <= x->data)
addHead(l1, p);
else
addHead(l2, p);
}
QuickSort(l1);
QuickSort(l2);
if (l1.pHead != NULL)
{
l.pHead = l1.pHead;
l1.pTail->pNext = x;
}
else
l.pHead = x;
x->pNext = l2.pHead;
if (l2.pHead != NULL)
l.pTail = l2.pTail;
else
l.pTail = x;
}
*/