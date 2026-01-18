/*
Vấn đề 2:Ứng dụng stack trong những bài toán đơn giản.
Bài toán: Tính giá trị của biểu thức dạng hậu tố.
Xét một biểu thức số học với các phép toán cộng, trừ, nhân, chia, lũy thừa, ...
Ví dụ:biểu thức a + (b - c) * d+ e. Biểu thức như trênđược viết theo ký pháp
trung tố, nghĩa là toán tử (dấu phép toán) đặt giữa hai toán hạng.Với ký pháp
trung tố, để phân biệt toán hạng ứng với toán tử nào ta phải dùng các cặp dấu
ngoặc đơn, và phải chấp nhận một thứ tự ưu tiên giữa các phép toán. Các
phép toán cùng thứ tự ưu tiên thì sẽ thực hiện theo trình tự từ trái sang phải.
Thứ tự ưu tiên như sau:
1. Phép lũy thừa
2. Phép nhân, chia
3. Phép cộng, trừ
Cách trình bày biểu thức theo ký pháp trung tố là tự nhiên với con người
nhưng lại “khó chịu” đối với máy tính, vì nó không thể hiện một cách tường
minh quá trình tính toán để đưa ra giá trị của biểu thức.Để đơn giản hóa quá
trình tính toán này, ta phải biến đổi lại biểu thức thông thường về dạng ký
pháp Ba Lan, gồm có có hai dạng là tiền tố (prefix) và hậu tố (postfix). Đó là
một cách viết biểu thức đại số rất thuận lợi cho việc thực hiện các phép toán.
Đặc điểm cơ bản của cách viết này là không cần dùng đến các dấu ngoặc và
luôn thực hiện từ trái sang phải.
Ta có thể biến đổi biểu thức dạng trung tố sang tiền tố hoặc hậu tố. Ví dụ:
A + B             | + A B         | A B +
A / B             | / A B         | A B /
(A + B) * C       | * + A B C     | A B + C*
(A + B) / (C – D) | / + A B – C D | A B + C D - /
A + B / C – D     | - + A / B C D | A B C / + D -
Cách tính giá trị của một biểu thức dạng hậu tố
Xét biểu thức dạng hậu tố sau đây: 128 + 4 - 2 4 * /
Nếu đọc biểu thức dang hậu tố từ trái qua phải ta sẽ thấy khi một toán tử
xuất hiện thì hai toán hạng vừa đọc sát nó sẽ được kết hợp với toán tử này để
tạo thành toán hạng mới ứng với toán tử sẽ được đọc sau nó, và cứ như vậy
Với biểu thức trên, các bước thực hiện lần lượt như sau:
Khi đọc phép: +, thực hiện 12 + 8 = 20
Khi đọc phép: -, thực hiện 20 – 4 = 16
Khi đọc phép: *, thực hiện 2 * 4 = 8
Khi đọc phép: /, thực hiện 16 / 8 = 2
Nhận xét: Trước khi đọc tới toán tử thì giá trị của các toán hạng phải được
lưu lại để chờ thực hiện phép tính. Hai toán hạng được đọc sau thì lại kết hợp
với toán tử đọc trước, điều đó cũng có nghĩa là hai giá trị được lưu lại sau thì
phải lấy ra trước để tính toán. Điều này trùng khớp với cơ chế “last in fist
out” của stack. Vì thế, để tính giá trị của biểu thức hậu tố người ta cần dùng
một stack để lưu các giá trị của toán hạng.
Cách thực hiện tính giá trị của biểu thức hậu tố có thể được tóm tắt như dưới
đây. Lưu ý, quy ước trình bày biểu thức là: biểu thức là một mảng ký tự,
trong đó các toán tử và các toán hạng được viết cách nhau bằng một ký tự
Tính giá trị của biểu thức dạng hậu tố:
Đọc từng “từ” của biểu thức hậu tố từ trái sang phải
(các “từ” cách nhau bằng một khoảng trắng). “Từ” đọc
được gọi là X.
Nếu X là toán hạng thì đưa X vào stack.
Nếu X là toán tử thì:
- Lần lượt lấy từ stack ra hai giá trị a và b (a lấy
trước, b lấy sau).
- Tính: kq = b X a (với X là phép toán).
- Đưa kq vào stack.
Quá trình trên được tiếp tục cho tới khi kết thúc biểu
thức. Lúc đó giá trị còn trong stack chính là giá trị
của biểu thức.
*/

#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
#include <cmath>

using namespace std;

struct Node {
    float data;
    Node *pNext;
};

struct Stack {
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

void DocTu (char s[], char tu[], int &vt){
    //Khoi tao tu ban dau chi chua cac khoang trang
    for (int i = 0; i < strlen(tu); i++){
        tu[i] = ' ';
    }
    int i = 0;
    while (s[vt] != ' '){
        tu[i] = s[vt];
        vt++;
        i++;
    } 
}

int LaToanTu (char s[]){
    char c = s[0];
    if ((c == '+') || (c == '-') || (c == '*') || (c == '/'))
        return 1;
    return 0;
}

float TinhToan (float toanHang1, float toanHang2, char toanTu){
    float kq;
    switch (toanTu){
        case '+':
            kq = toanHang1 + toanHang2;
            break;
        case '-':
            kq = toanHang1 - toanHang2;
            break;
        case '*':
            kq = toanHang1 * toanHang2;
            break;
        case '/':
            kq = toanHang1 / toanHang2;
    }
    return kq;
}

float TinhBieuThuc (Stack &s, char bieuThuc[]){
    float kq;
    char t[10];
    int i = 0;
    do{
        DocTu(bieuThuc, t, i);//Trong chuoi bieuThuc, doc mot tu bat dau tu vi tri i, ket qua la tu t
        if (LaToanTu(t)){
            char toanTu = t[0];
            float toanHang1 = Pop(s);
            float toanHang2 = Pop(s);
            kq = TinhToan (toanHang2, toanHang1, toanTu);//Thuc hien phep tinh
            Push (s, kq); //tinh xong dua ket qua vao stack
        }
        else{ // t la toan hang
            float toanHang = atof(t); //Chuyen thanh so thuc
            Push (s, toanHang); //dua toan hang vao stack
        }
        i++;
    }while(bieuThuc[i] != '#'); //gia su quy uoc # la ky tu ket thuc bieu thuc
    return Pop(s);
}

int main(){
    Stack s;
    initStack(s);
    char bieuThuc[100] = "";
    cout << "Nhap bieu thuc dang hau to\n";
    fflush(stdin);
    gets(bieuThuc);
    float kq = TinhBieuThuc (s, bieuThuc);
    cout << "Gia tri bieu thuc la: " << kq << endl;
    return 0;
}

//5 17 + 20 + 3 + #
//=> 45
//5 3 2 * 6 - 1 + #
//=> 6
//5 6 7 * 8 / + 6 - #
//=> 4.25