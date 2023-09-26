#include <stdio.h>
#include <locale.h>

int main() {
setlocale(LC_ALL, "Portuguese");
  
  int i, n, valor, min, count = 0;
  int vetor[10];

  for (i = 0; i < 10; i++) 
  {
    printf("Digite o %d° número: ", i + 1);
    scanf("%d", &vetor[i]);
  }

  min = vetor[0];
  for (i = 0; i < 10; i++) 
  {
    if (vetor[i] < min) 
	{
      min = vetor[i];
    }
  }

  for (i = 0; i < 10; i++) 
  {
    if (vetor[i] == min) 
	{
      count++;
    }
  }

  printf("Menor valor: %d\n", min);
  printf("Número de vezes que o menor valor apareceu: %d\n", count);

  return 0;
}

