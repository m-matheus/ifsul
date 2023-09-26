#include <stdio.h>
#include <locale.h>

int main() {
	setlocale(LC_ALL, "Portuguese");
    float b[9][9];
    float soma_linha;
    int i, j;
    
    // Preencher a matriz com os valores de entrada
    for (i = 0; i < 9; i++) {
        for (j = 0; j < 9; j++) {
            printf("Digite o valor para b[%d][%d]: ", i, j);
            scanf("%f", &b[i][j]);
        }
    }

    // Ccalcular a soma dos elementos de cada linha ímpar
    for (i = 0; i < 9; i += 2) {
        soma_linha = 0;
        for (j = 0; j < ; j++) {
            soma_linha += b[i][j];
        }
        printf("A soma dos elementos da linha ímpar %d é: %.2f\n", i+1, soma_linha);
    }

    return 0;
}
