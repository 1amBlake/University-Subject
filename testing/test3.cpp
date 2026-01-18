#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char ID[20];
    char Name[100];
    char Gender[10];
    double Grade;
} Student;

typedef struct Node {
    Student data;
    struct Node* link;
} Node;

typedef struct {
    Node* first;
    Node* last;
} ListStudent;

// 1. Khởi tạo danh sách rỗng
void Init(ListStudent* L) {
    L->first = NULL;
    L->last = NULL;
}

// Hàm tạo node mới
Node* CreateNode(Student s) {
    Node* p = (Node*)malloc(sizeof(Node));
    p->data = s;
    p->link = NULL;
    return p;
}

// 2. Đọc dữ liệu từ file
void ReadStudent(ListStudent* L, const char* filename) {
    FILE* f = fopen(filename, "r");
    if (!f) {
        printf("Cannot open file %s\n", filename);
        return;
    }

    Student s;
    while (fscanf(f, "%[^,],%[^,],%[^,],%lf\n",
        s.ID, s.Name, s.Gender, &s.Grade) == 4) {
        Node* p = CreateNode(s);
        if (L->first == NULL) {
            L->first = L->last = p;
        } else {
            L->last->link = p;
            L->last = p;
        }
    }
    fclose(f);
}

// 3. Update giới tính
void UpdateAllGender(ListStudent* L) {
    Node* p = L->first;
    while (p != NULL) {
        if (strcmp(p->data.Gender, "Male") == 0) {
            strcpy(p->data.Gender, "Nam");
        } else if (strcmp(p->data.Gender, "Female") == 0) {
            strcpy(p->data.Gender, "Nu");
        }
        p = p->link;
    }
}

// 4. Hiển thị h sinh viên đầu tiên
void ShowStudentHeads(ListStudent L, int h) {
    Node* p = L.first;
    int count = 0;
    while (p != NULL && count < h) {
        printf("%s\t%s\t%s\t%.2f\n",
            p->data.ID, p->data.Name,
            p->data.Gender, p->data.Grade);
        p = p->link;
        count++;
    }
}

// ================== MAIN TEST ==================
int main() {
    ListStudent L;
    Init(&L);

    char filename[] = "Data_Student1.txt";
    ReadStudent(&L, filename);

    UpdateAllGender(&L);

    int h = 5;
    ShowStudentHeads(L, h);

    return 0;
}
