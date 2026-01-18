/*
Vấn đề 1: Cài đặt các thao tác cơ bản trên queuedùng danh sách liên kết.
Hai thao tác chính trên queue gồm có: thêm và lấy phần tử ra khỏi queue.
Đối với queuedùng danh sách liên kết thì thêm phần tử vào queuechính là
thao tác thêm phần tử vào cuối danh sách liên kết. Lấy phần tử ra khỏi
queuechính là thao tác lấy phần tử ở đầu danh sách ra khỏi danh sách liên
kết. Ta cũng cần một thao tác hỗ trợ là kiểm tra danh sách rỗng.
(Lưu ý: ta cũng có thể thêm phần tử vào đầu danh sách liên kết, khi đó, để
lấy phần tử ra khỏi danh sách, ta thực hiện lấy phần tử ở cuối danh sách liên
*/

#include <iostream>

using namespace std;

struct Node {
    int data;
    Node *pNext;
};

struct Queue {
    Node *front;
    Node *rear;
};

//Khoi tao queue
void initQueue (Queue &q) {
    q.front = nullptr;
    q.rear = nullptr;
}

//Kiem tra queue rong
int Empty (Queue q){
    return q.front == nullptr ? 1 : 0;
}

//Them phan tu x vao queue
void enQueue (Queue &q, int x){
    Node *p = new Node;
    p->data = x;
    p->pNext = nullptr;
    if (Empty(q)){
        q.front = p;
        q.rear = p;
    }
    else {
        q.rear->pNext = p;
        q.rear = p;
    }
}

//Trich thong tin va huy phan tu o dinh queue
int deQueue (Queue &q){
    if (Empty(q)){
        cout << "Queue is empty!" << endl;
        return 1;
    }
    Node *p = q.front;
    q.front = q.front->pNext;
    if (Empty(q))
        q.rear = nullptr;
    int x = p->data;
    delete p;
    return x;
}

//Xem thong tin o phan tu dau Queue
int Front (Queue q){
    if (Empty(q))
        return 1;
    return q.front->data;
}

int main(){
    Queue q;
    int k;
    initQueue(q);
    cout << "Enter number of elements to enqueue (-1 to stop): ";
    cin >> k;
    while (k != -1){
        enQueue (q, k);
        cin >> k;
    }
    cout << "Extracting elements from queue: ";
    while (Empty(q) == 0){
        k = deQueue(q);
        cout << k << " ";
    }
    return 0;
}