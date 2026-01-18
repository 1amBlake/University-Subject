/*Thuật toán tìm kiếm nhị phân.
Thuật toán tìm kiếm nhị phân dùng để tìm kiếm phần tử trong một danh sách
đã được sắp xếp, ví dụ như trong một danh bạ điện thoại sắp xếp theo tên, có
thể tìm kiếm số điện thoại của một người theo tên người đó*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//Hàm tìm kiếm nhị phận đệ qu
int BinarySearch(int a[], int left, int right, int x){
    if(left > right)
        return -1; 
    int mid = (left + right) / 2;
    if(a[mid] == x)
        return mid;
    else if (a[mid] > x)
        return BinarySearch(a, left, mid - 1, x);
    else
        return BinarySearch(a, mid + 1, right, x);
}

//Phát sinh mảng tăng
void PhatSinhMangTang(int a[], int n){
    srand(time(NULL));
    a[0] = rand() % 10; //Phát sinh phần tử đầu tiên
    for (int i = 1; i < n; i++){
        a[i] = a[i - 1] + rand() % 10 + 1; //Phần tử sau lớn hơn phần tử trước ít nhất 1 đơn vị
    }
}

int main(){
    int a[100], n, x;
    printf("Ban can phat sinh mang co bao nhieu PT?");
    scanf("%d", &n);
    PhatSinhMangTang(a, n);
    printf("Nhap khoa can tim: ");
    scanf("%d", &x);
    int kq = BinarySearch(a, 0, n - 1, x);
    if (kq == -1)
        printf("Khong tim thay");
    else
        printf("Tim thay tai vi tri: %d", kq);
    return 0;
    
}