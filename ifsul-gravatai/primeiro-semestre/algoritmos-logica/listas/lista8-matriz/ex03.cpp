#include <stdio.h>
#include <locale.h>

int main() {
setlocale(LC_ALL, "Portuguese");

int m[5][5];
int i, j, a, cont=0;

printf("Digite um valor: ");
scanf("%d", &a);

for(i=0; i<5; i++)
	{
		for(j=0; j<5; j++)
			{
				scanf("%d", &m[i][j]);
				if(a != m[i][j]) {
					cont++;
				}
			}
	}
    printf("Quantidade de variaveis diferentes do digitado: %d", cont);
    
	return 0;
}

