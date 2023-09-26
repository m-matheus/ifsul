#include <stdio.h>
#include <locale.h>

main() {
setlocale(LC_ALL, "Portuguese");

	int i, x[10], y[10], j=0;
	
	printf("Digite 10 valores: \n");
	
	for(i = 0; i < 10; i++)
	{
		scanf("%d", &x[i]);
		if(x[i] % 2 == 0) 
		{
		y[j] = x[i];
		j++;
		}
	}
	
	printf("Valores pares digitados:\n");
	for(i = 0; i < j; i++)
	{
		printf("%d |", y[i]);
	}
	printf("\nQuantidade de números pares: \n%d", j);

	return(0);
}

