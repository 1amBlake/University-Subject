/*Thuật toán tìm kiếm tuyến tính (tìm tuần tự).
Là một phương pháp tìm kiếm một phần tử cho trước trong một danh
sách bằng cách duyệt lần lượt từng phần tử của danh sách đó cho đến lúc
tìm thấy giá trị mong muốn hay đã duyệt qua toàn bộ danh sách*/

#include <stdio.h>

void NhapMang(int a[], int n){
    for (int i = 0; i < n; i++){
        printf("Nhap a[%d]: ", i);
        scanf("%d", &a[i]);
    }
}

int LinearSearch (int a[], int n, int x){
    int i = 0;
    while(i < n && a[i] != x)
        i++;
    if (i < n) //a[i] là phần tử có khóa x
        return i;
    return -1; //tìm hết mảng những không có x
}

/* LinearSerach cải tiến
void LinearSearch(int a[], int n. int x){
    int i = 0;
    a[n] = x;
    while (a[i] != x)
        i++;
    if (i < n)
        return i;
    return -1;
    }
*/

int main(){
    int a[100], n, x;
    printf("Nhap so phan tu cua mang: ");
    scanf("%d", &n);
    NhapMang(a, n);
    printf("Nhap khoa can tim: ");
    scanf("%d", &x);
    int kq = LinearSearch(a, n, x);
    if (kq == -1)
        printf("Khong tim thay");
    else
        printf("Tim thay tai vi tri: %d", kq);
    return 0;
}