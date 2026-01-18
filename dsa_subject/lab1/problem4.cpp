#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Hàm tìm tuyến tính
int LinearSearch(int a[], int n, int x) {
    for (int i = 0; i < n; i++) {
        if (a[i] == x) return i;
    }
    return -1;
}

// Hàm tìm nhị phân (không đệ quy cho nhanh)
int BinarySearch(int a[], int left, int right, int x) {
    while (left <= right) {
        int mid = (left + right) / 2;
        if (a[mid] == x) return mid;
        else if (a[mid] > x) right = mid - 1;
        else left = mid + 1;
    }
    return -1;
}

int main() {
    int n = 100000;
    int *a = (int*)malloc(n * sizeof(int));

    // Sinh mảng tăng dần
    a[0] = 1;
    for (int i = 1; i < n; i++) {
        a[i] = a[i-1] + 1;  // mảng [1,2,3,...]
    }

    int x = n; // tìm phần tử cuối cùng để so sánh

    clock_t start, end;
    double t;

    // Tìm tuyến tính
    start = clock();
    int kq1 = LinearSearch(a, n, x);
    end = clock();
    t = (double)(end - start) / CLOCKS_PER_SEC;
    printf("LinearSearch: vi tri %d, thoi gian %f s\n", kq1, t);

    // Tìm nhị phân
    start = clock();
    int kq2 = BinarySearch(a, 0, n-1, x);
    end = clock();
    t = (double)(end - start) / CLOCKS_PER_SEC;
    printf("BinarySearch: vi tri %d, thoi gian %f s\n", kq2, t);

    free(a);
    return 0;
}
