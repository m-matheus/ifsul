#include <stdio.h>
#include <locale.h>

int main() {
setlocale(LC_ALL, "Portuguese");
  
  int i, n, pos1, pos2, aux;
  int vetor[10];

  for (i = 0; i < 10; i++) 
  {
    printf("Digite o %d° número: ", i + 1);
    scanf("%d", &vetor[i]);
  }

  printf("Digite a primeira posição para trocar: ");
  scanf("%d", &pos1);

  printf("Digite a segunda posição para trocar: ");
  scanf("%d", &pos2);

  aux = vetor[pos1];
  vetor[pos1] = vetor[pos2];
  vetor[pos2] = aux;

  printf("Vetor com as posições trocadas:\n");
  for (i = 0; i < 10; i++) 
  {
    printf("%d ", vetor[i]);
  }
  printf("\n");

  return 0;
}

