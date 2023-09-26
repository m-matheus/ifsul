#include <stdio.h>
#include <locale.h>

int main() {
	setlocale(LC_ALL, "Portuguese");
    char R[10], P[10];
    int acertos = 0;
    
    // Ler as respostas corretas da prova
    printf("Digite as respostas corretas da prova (A, B, C ou D):\n");
    for (int i = 0; i < 10; i++) {
        printf("Questao %d: ", i+1);
        scanf(" %c", &R[i]);
    }
    // Ler as respostas do aluno
    printf("\nDigite as respostas do aluno (A, B, C ou D):\n");
    for (int i = 0; i < 10; i++) {
        printf("Questao %d: ", i+1);
        scanf(" %c", &P[i]);
    }
    // Comparar as respostas e contar acertos
    for (int i = 0; i < 10; i++) {
        if (R[i] == P[i]) {
            acertos++;
        }
    }
    // Mostrar o número de acertos do aluno
    printf("\nO aluno acertou %d questoes.\n", acertos);
    
    return 0;
}
