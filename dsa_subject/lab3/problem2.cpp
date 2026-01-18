/* Vấn đề 2: Thực hiện một số thao tác cơ bản trên danh sách liên kết đơn.
Danh sách liên kết đơn có mỗi phần tử chứa dữ liệu là một số nguyên. Hãy
thực hiện các thao tác sau đây:
1. Định nghĩa cấu trúcNodevà cấu trúc List (List gồm hai con trỏ trỏ đến
đầu và cuối danh sách)
2. Xây dựng hàm tạo danh sách rỗng void Init (List &L)
3. Xây dựng hàm Node* GetNode (int x)để tạo một Node mà trường data
nhận giá trị x và trường link nhận giá trị NULL. Hàm trả về con trỏ
TRỎ vào nút vừa tạo hoặc trả về NULL trong trường hợp không thành
công.
4. Xây dựng hàm void AddFirst (List &L, Node* p) để thêm một Node
mới vào đầu danh sách được quản lý bởi L.
5. Xây dựng hàm void InsertFirst (List &L, int x) để thêm một Node
mới chứa dữ liệu x vào đầu danh sách được quản lý bởi L.
6. Xây dựng hàm void CreateListFirst( List &L) để tạo danh sách bằng
cách thêm vào đầu danh sách. Việc nhập sẽ dừng khi người dùng nhập
-1.
7. Xuất danh sách liên kết đơn L.
8.Chương trình chính
11. Viết hàm trả về tổng của các phần tử có giá trị chẳn trong danh sách.
long SumEvenNumber (List L);
12. Viết hàm tìm xem có phần tử có giá trị x trong danh sách hay không.
Nếu có trả về con trỏ TRỎ đến Node tương ứng, không có thì trả về
NULL.
Node*Search(List L, int x);
*/
#include <iostream>

using namespace std;

//1. Dinh nghia cau truc Node va List
struct Node{
    int data;
    Node *link;
};

struct List {
    Node *first;
    Node *last;
};

//2. Ham tao danh sach rong
void Init (List &l){
    l.first = l.last = nullptr;
}

//3. Ham tao Node
Node *GetNode (int x){
    Node *p = new Node;
    if (p==nullptr)
        return nullptr;
    p->data = x;
    p->link = nullptr;
    return p;
}

//4. Ham them Node vao dau danh sach
void AddFirst (List &l, Node *new_ele){
    if (l.first == nullptr){
        l.first = l.last = new_ele;
    }
    else {
        new_ele->link = l.first;
        l.first = new_ele;
    }
}

//5. Ham them Node chua du lieu x vao dau danh sach
void InsertFirst (List &l, int x){
    Node *new_ele = GetNode(x);
    if (new_ele == nullptr)
        return;
    AddFirst(l, new_ele);
}

//6. Ham tao danh sach bang cach them vao dau danh sach
void CreateListFirst (List &l){
    int x;
    do{
        cout << "Bat dau nhap danh sach cac so nguyen (Nhap -1 de ket thuc): ";
        cin >> x;
        if (x != -1)
            InsertFirst(l, x);
    }while (x != -1);
    cout << "Da nhap du lieu xong!" << endl;
}

//7. Ham xuat danh sach lien ket don 
void PrintList (List l){
    Node *p = l.first;
    while (p != nullptr){
        cout << p->data << " ";
        p = p->link;
    }
}

//11. Ham tra ve tong cac phan tu co gia tri chan trong danh sach
long SumEvenNumber (List l){
    long sum = 0;
    Node *p = l.first;
    while (p != nullptr){
        if (p->data % 2 == 0)
            sum += p->data;
        p = p->link;
    }
    return sum;
}

//12. Ham tim xem co phan tu co gia tri x trong danh sach hay khong
Node* Search (List l, int x){
    Node *p = l.first;
    while (p != nullptr){
        if (p->data == x)
            return p;
        p = p->link;
    }
    return nullptr;
}   

int main(){
    List l;
    Init(l);
    CreateListFirst(l);
    cout << "Danh sach lien ket don vua nhap la: ";
    PrintList(l);
    cout << endl;

    long sum_even = SumEvenNumber(l);
    cout << "Tong cac phan tu co gia tri chan trong danh sach: " << sum_even << endl;

    int x;
    cout << "Nhap gia tri can tim: ";
    cin >> x;
    Node *result = Search(l, x);
    if (result != nullptr)
        cout << "Tim thay phan tu co gia tri " << x << " trong danh sach." << endl;
    else
        cout << "Khong tim thay phan tu co gia tri " << x << " trong danh sach." << endl;

    return 0;
}