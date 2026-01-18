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

int main() {
    List l;
    Init(l);
    NhapDSSV(l);
    XuatDSSV(l);
    return 0;
}
