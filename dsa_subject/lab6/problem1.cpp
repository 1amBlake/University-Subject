/*Cài đặt các thao tác cơ bản trên stack dùng danh sách liên kết.
Hai thao tác chính trên stack gồm có: thêm và lấy phần tử ra khỏi stack. Đối
với stack dùng danh sách liên kết thì thêm phần tử vào stack chính là thao
tác thêm phần tửvào đầu danh sách liên kết. Lấy phần tử ra khỏi stack chính
là thao tác lấy phần tử ở đầu danh sách ra khỏi danh sách liên kết. Ta cũng
cần một thao tác hổ trợ là kiểm tra danh sách rỗng.*/

#include <iostream>

using namespace std;

struct Node{
    int data; //Gia su stack chua so nguyen
    Node* pNext; //Link
};

struct Stack{
    Node *top;
};

//Khoi tao stack
void initStack (Stack &s){
    s.top = nullptr;
}

//Kiem tra stack rong
int Empty (Stack s){
    return s.top == nullptr ? 1 : 0;
} 

//Them mot phan tu vao stack
void Push (Stack &s, float x){
    Node *p = new Node;
    if (p != nullptr ){
        p->data = x;
        p->pNext = s.top;
        s.top = p;
    }
}

//Trich thong tin va huy mot phan tu o dinh stack
float Pop (Stack &s){
    float x;
    if (!Empty(s)){
        Node *p = s.top;
        s.top = p->pNext;
        x = p->data;
        delete p;
        return x;
    }
}

int main(){
    Stack s;
    initStack(s);
    cout << "Enter number to push (-1 to stop): ";
    float num;
    do{
        cin >> num;
        if (num != -1)
            Push (s, num);
    }while (num != -1);
    cout << "Popping elements: ";
    while (!Empty(s)){
        cout << Pop (s) << " ";
    }
}