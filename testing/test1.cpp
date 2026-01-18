#include <stdio.h>

void SearchingAboveAvg(int arr[], int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += arr[i];
    }

    double avg = (double)sum / n;

    printf("Above the average %.2f includes:", avg);
    for (int i = 0; i < n; i++) {
        if (arr[i] > avg) {
            printf(" %d", arr[i]);
        }
    }
    printf("\n");
}

int main() {
    int n1 = 9;
    int arr1[1000] = {1, 2, 2, 8, 3, 8, 2, 8, 9};
    SearchingAboveAvg(arr1, n1);

    int n2 = 10;
    int arr2[1000] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    SearchingAboveAvg(arr2, n2);

    int n3 = 10;
    int arr3[1000] = {16, 10, 27, 12, 17, 18, 25, 19, 16, 22};
    SearchingAboveAvg(arr3, n3);

    return 0;
}
