#include <iostream>
using namespace std;

void swap(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

void printArray(int a[], int n) {
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";
    cout << endl;
}

void selectionSort(int a[], int n) {
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++)
            if (a[j] < a[minIndex])
                minIndex = j;
        swap(a[i], a[minIndex]);
    }
}

void insertionSort(int a[], int n) {
    for (int i = 1; i < n; i++) {
        int key = a[i];
        int j = i - 1;
        while (j >= 0 && a[j] > key) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = key;
    }
}

void interchangeSort(int a[], int n) {
    for (int i = 0; i < n - 1; i++)
        for (int j = i + 1; j < n; j++)
            if (a[i] > a[j])
                swap(a[i], a[j]);
}

void bubbleSort(int a[], int n) {
    for (int i = 0; i < n - 1; i++)
        for (int j = 0; j < n - i - 1; j++)
            if (a[j] > a[j + 1])
                swap(a[j], a[j + 1]);
}

int partition(int a[], int low, int high) {
    int pivot = a[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (a[j] < pivot) {
            i++;
            swap(a[i], a[j]);
        }
    }
    swap(a[i + 1], a[high]);
    return i + 1;
}

void quickSort(int a[], int low, int high) {
    if (low < high) {
        int pi = partition(a, low, high);
        quickSort(a, low, pi - 1);
        quickSort(a, pi + 1, high);
    }
}

int main() {
    int n, choice;
    int a[100]; 

    cout << "Nhap so phan tu: ";
    cin >> n;

    cout << "Nhap cac phan tu:\n";
    for (int i = 0; i < n; i++)
        cin >> a[i];

    cout << "\nChon thuat toan sap xep:\n";
    cout << "1. Chon truc tiep (Selection sort)\n";
    cout << "2. Chen truc tiep (Insertion sort)\n";
    cout << "3. Doi cho truc tiep (Interchange sort)\n";
    cout << "4. Noi bot (Bubble sort)\n";
    cout << "5. Quick sort\n";
    cout << "Lua chon: ";
    cin >> choice;

    switch (choice) {
        case 1: selectionSort(a, n); break;
        case 2: insertionSort(a, n); break;
        case 3: interchangeSort(a, n); break;
        case 4: bubbleSort(a, n); break;
        case 5: quickSort(a, 0, n - 1); break;
        default:
            cout << "Lua chon khong hop le!\n";
            return 0;
    }

    cout << "\nMang sau khi sap xep:\n";
    printArray(a, n);
    system("pause");
    return 0;
}
