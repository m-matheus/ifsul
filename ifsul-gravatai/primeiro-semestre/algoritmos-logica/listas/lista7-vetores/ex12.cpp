#include <stdio.h>
#include <locale.h>

main() {
setlocale(LC_ALL, "Portuguese");

	int x[5], y[5], i, j, prod;
	
	printf("Digite 5 valores: ");
	for(i = 0; i < 5; i++)
	{
		scanf("%d", &x[i]);
	}
	
	printf("Digite mais 5 valores: ");
	for(i = 0; i < 5; i++)
	{
		scanf("%d", &y[i]);
	}
	
	printf("Agora somaremos os vetores em suas respectivas posições: \n");
	
	for(i = 0; i < 5; i++)
	{
		prod = x[i] * y[i];
		printf("O resultado do %d° produto é: %d\n",i+1, prod);
	}

	return(0);
}

