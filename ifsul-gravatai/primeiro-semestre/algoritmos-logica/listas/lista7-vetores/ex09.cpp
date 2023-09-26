#include <stdio.h>
#include <locale.h>

int main() {
setlocale(LC_ALL, "Portuguese");

    int A[10], x, count = 0, i;
    
    printf("Insira 10 elementos do vetor A:\n");
    for (i = 0; i < 10; i++) 
	{
        scanf("%d", &A[i]);
    }
    
	printf("Insira o valor de x: ");
    scanf("%d", &x);
    
	for (i = 0; i < 10; i++) 
	{
        if (A[i] == x) 
		{
            count++;
        }
    }
    
	printf("O valor %d ocorre %d vezes no vetor A\n", x, count);
    
	return 0;
}

