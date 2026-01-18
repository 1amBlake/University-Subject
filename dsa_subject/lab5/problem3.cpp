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

// Khởi tạo danh sách
void Init(List &l) {
    l.first = nullptr;
    l.last = nullptr;
}

// Cấp phát node mới
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

// Thêm node cuối
void AddLast(List &l, Node* p) {
    if (l.first == nullptr) {
        l.first = p;
        l.last = p;
    } else {
        l.last->link = p;
        l.last = p;
    }
}

// Thêm node đầu
void AddFirst(List &l, Node* p) {
    if (l.first == nullptr)
        l.first = l.last = p;
    else {
        p->link = l.first;
        l.first = p;
    }
}

// Tìm sinh viên theo mã
Node* Search(List l, const char* maSV) {
    for (Node* p = l.first; p != nullptr; p = p->link) {
        if (strcmp(p->data.maSV, maSV) == 0)
            return p;
    }
    return nullptr;
}

// Nhập thông tin sinh viên
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

// Sắp xếp danh sách theo họ tên (Interchange sort)
void InterchangeSortList(List &L) {
    for (Node *i = L.first; i != L.last; i = i->link) {
        for (Node *j = i->link; j != nullptr; j = j->link) {
            if (strcmp(i->data.hoTen, j->data.hoTen) > 0) {
                swap(i->data, j->data);
            }
        }
    }
}

// Thêm đầu danh sách (không trùng mã)
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

// Nhập danh sách sinh viên
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

// Xuất 1 sinh viên
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

// Xuất toàn bộ danh sách
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

// Xóa node đầu danh sách
int RemoveFirst(List &L) {
    if (L.first == nullptr) return 0;
    Node* p = L.first;
    L.first = p->link;
    if (L.first == nullptr)
        L.last = nullptr; // Nếu danh sách rỗng
    delete p;
    return 1;
}

// Xóa node sau node q
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

// Tìm node đứng trước node có mã x
Node* TimXoa(List L, char x[]) {
    Node* p = L.first;
    while (p != nullptr && p->link != nullptr) {
        if (strcmp(p->link->data.maSV, x) == 0)
            return p;
        p = p->link;
    }
    return nullptr;
}

// Xóa node có mã sinh viên là x
int RemoveX(List &L, char x[]) {
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
