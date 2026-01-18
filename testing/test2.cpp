#include <stdio.h>

// Hàm sắp xếp giảm dần (Bubble Sort / Selection Sort đều được)
void DecreasingSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] < arr[j]) {
                // Đổi chỗ
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

// Hàm in k phần tử đầu tiên
void Display(int arr[], int n, int k) {
    if (k > n) k = n; // tránh trường hợp k > n
    for (int i = 0; i < k; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int n = 9, k = 5;
    int arr1[1000] = {16, 10, 27, 12, 17, 18, 25, 19, 16, 22};
    DecreasingSort(arr1, n);
    Display(arr1, n, k);

    int n2 = 9, k2 = 10;
    int arr2[1000] = {1, 2, 2, 8, 3, 8, 2, 8, 9};
    DecreasingSort(arr2, n2);
    Display(arr2, n2, k2);

    int n3 = 10, k3 = 5;
    int arr3[1000] = {16, 10, 27, 12, 17, 18, 25, 19, 16, 22};
    DecreasingSort(arr3, n3);
    Display(arr3, n3, k3);

    return 0;
}
