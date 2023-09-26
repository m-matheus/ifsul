#include <stdio.h>

int main() {
    int A[10], i, soma=0;
    for (i=0; i<10; i++) {
        printf("Insira o %dº valor: ", i+1);
        scanf("%d", &A[i]);
        soma += A[i];
    }
    printf("A soma dos valores é: %d\n", soma);
    return 0;
}

