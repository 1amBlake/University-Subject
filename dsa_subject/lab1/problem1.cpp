/*
Vấn đề 1: Ôn tập các thao tác trên mảng một chiều
Cho mảng a có n phần tử số nguyên. Viết các hàm thực hiện các công
việc:nhập/ xuất mảng, phát sinh mảng, đọc/ ghi mảng vào file
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void NhapMang(int a[], int n) {
    for (int i = 0; i < n; i++) {
        printf("Nhap a[%d]: ", i);
        scanf("%d", &a[i]);
    }
}

void PhatSinhMang(int a[], int n){
    srand(time(NULL));
    for (int i = 0; i < n; i++) {
        a[i] = rand() % 100; // Phát sinh số nguyên ngẫu nhiên từ 0 đến 99
    }
}

void XuatMang(int a[], int n){
    printf("\n");
    for(int i = 0; i < n; i++) {
        printf("%10d ", a[i]);
    }
}

int GhiMangVaoFile(const char* filename, int a[], int n) {
    FILE* f = fopen(filename, "w");
    if (!f) return 0;
    for (int i = 0; i < n; i++) {
        fprintf(f, "%d\t", a[i]);
    }
    fclose(f);
    return 1;
}

/*int DocMangTuFile(const char* filename, int a[], int* n) {
    FILE* f = fopen(filename, "r");
    if (!f) return 0;
    int i = 0;
    while(!feof(f)){
        fscanf(f, "%d", &a[i]);
        i++;
    }
    *n = i;
    return 1;
}*/

int DocMangTuFile(const char* filename, int a[], int* n) {
    FILE* f = fopen(filename, "r");
    if (!f) return 0;

    int i = 0;
    while (fscanf(f, "%d", &a[i]) == 1) {
        i++;
    }
    *n = i;

    fclose(f);
    return 1;
}


int main() {
    int n;
    printf("Nhap so luong phan tu mang: ");
    scanf("%d", &n);
    int* a = (int*)malloc(n * sizeof(int));

    PhatSinhMang(a, n);
    XuatMang(a, n);

    const char* filename = "mang.txt";
    if (GhiMangVaoFile(filename, a, n)) {
        printf("\nGhi mang vao file thanh cong.\n");
    } else {
        printf("\nGhi mang vao file that bai.\n");
    }

    int m;
    int* b = (int*)malloc(n * sizeof(int));
    if (DocMangTuFile(filename, b, &m)) {
        printf("Doc mang tu file thanh cong. Mang doc duoc:\n");
        XuatMang(b, m);
    } else {
        printf("Doc mang tu file that bai.\n");
    }

    free(a);
    free(b);
    return 0;
}