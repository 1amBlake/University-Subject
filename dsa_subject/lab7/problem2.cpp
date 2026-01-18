/* 
Vấn đề 2: Ứng dụng Queue trong những bài toán đơn giản.
Bài toán: Lập trình Queue giải quyết bài toán quản lý kho (nhập trước – xuất
trước) như sau:
1. Nhập một mặt hàng
2. Xuất một mặt hàng
3. Xem mặt hàng chuẩn bị xuất
4. Xem mặt hàng mới nhập
5. Xem các mặt hàng có trong kho
6. Xuất toàn bộ kho hàng
7. Kết thúc chương trình
CHỨC NĂNG BẠN CHỌN :[1..7]:
*/

#include <iostream>
#include <limits>

#define MAX 100

using namespace std;

//Khai bao cua truc mat hang
typedef struct MatHang {
    int MaHang;
    char TenHang[12];
} MT;

struct Queue {
    int n;
    int front;
    int rear;
    MT list[MAX];
};

void Init (Queue &q){
    q.front = 0;
    q.rear = MAX - 1;
    q.n = 0;
}

int Empty (Queue q){
    if (q.n == 0)
        return 1;
    return 0;
}

//kiem tra day
int isFull (Queue q){
    if (q.n == MAX)
        return 1;
    return 0;
}

//Them mot phan tu vao queue
int enQueue (Queue &q, MT x){
    if (isFull(q))
        return 0; //queue day
    q.rear = (q.rear + 1) % MAX;
    q.list [q.rear] = x;
    q.n++;
    return 1;
}

//Xoa mot phan tu trong queue
MT deQueue(Queue &q){
    if (!Empty(q)){
        MT x = q.list[q.front];
        q.front = (q.front + 1) % MAX;
        q.n--;
        return x;
    }
    MT temp; // hoặc có thể thông báo lỗi và return một struct "rỗng"
    temp.MaHang = -1;
    return temp;
}

//Nhap mot mat hang
int NhapMatHang (MT &x){
    cout << endl << "Nhap ma hang: ";
    cin >> x.MaHang;
    if (x.MaHang <= 0)
        return 0;
    cin.ignore(numeric_limits<streamsize>::max(), '\n'); //Xoa bo dem sau khi nhap so
    cout << "Nhap ten hang: ";
    cin.getline(x.TenHang, 12);
}

//Nhap danh sach cac mat hang vao queue
void NhapDSMatHang (Queue &q){
    MT x;
    cout << "Nhap Ma Hang = 0 de dung" << endl;
    int flag = NhapMatHang(x);
    while (flag){
        enQueue(q, x);
        flag = NhapMatHang(x);
    }
    cout << "\n Ket thuc nhap DS mat hang";
}

//Xuat thong tin mat hang
void xuatMatHang (MT x){
    cout << endl << "Ma hang: " << x.MaHang;
    cout << endl << "Ten hang: " << x.TenHang;
}

//Xuat queue
void xuatQueue (Queue q){
    MT x;
    int i = q.n;
    if (Empty(q)){
        cout << endl << "Kho khong con hang!";
        return;
    }
    //Vong lap in cac nut tu front den nut ke cuoi
    while (i != 0){
        x = q.list[q.front];
        xuatMatHang(x);
        q.front = (q.front + 1) % MAX;
        i--;
    }
}

//Xuat thong tin mat hang chuan bi xuat
void outputFront (Queue q){
    if (!Empty(q)){
        MT x = q.list[q.front];
        xuatMatHang(x);
    }
}

//Xuat thong tin mat hang vua moi nhap
void outputRear (Queue q){
    if (!Empty(q)){
        MT x = q.list[q.rear];
        xuatMatHang(x);
    }
}

int main(){
    Queue q;
    Init(q);
    NhapDSMatHang(q);
    xuatQueue(q);
    cout << endl << "Mat hang sap xuat: " << endl;
    outputFront(q);
    cout << endl << "Mat hang vua nhap: " << endl;
    outputRear(q);
    cout << endl << "Xoa phan tu khoi Queue: " << endl;
    deQueue(q);
    cout << endl << "Ket qua Queue sau khi xoa: " << endl;
    xuatQueue(q);
    return 0;
}