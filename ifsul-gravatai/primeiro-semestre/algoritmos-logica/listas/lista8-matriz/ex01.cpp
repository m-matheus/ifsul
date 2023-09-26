#include <stdio.h>
#include <locale.h>

int main() {
setlocale(LC_ALL, "Portuguese");

int m[5][5];
int i, j, soma;

for(i=0; i<5; i++)
	{
		for(j=0; j<5; j++)
			{
				scanf("%d", &m[i][j]);
				soma += m[i][j];
			}
	}
    printf("Valor da soma: %d", soma);
    
	return 0;
}

