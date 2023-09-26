#include <stdio.h>
#include <locale.h>

main() {
setlocale(LC_ALL, "Portuguese");

	int i, x[7], p=0, im=0, n=0;
	
	printf("Digite 7 valores: \n");
	
	for(i = 0; i < 7; i++)
	{
		scanf("%d", &x[i]);		
	}
	
	printf("Valores pares: \n");
	for(i = 0; i < 7; i++)
	{
		if(x[i] % 2 == 0)
		{
			printf("%d |", x[i]);
			p++;
				}		
	}
	
	printf("\nValores ímpares: \n");
	for(i = 0; i < 7; i++)
	{
		if(x[i] % 2 != 0)
		{
			printf("%d |", x[i]);
			im++;
				}
	}

	printf("\nValores Negativos: \n");
	for(i = 0; i < 7; i++)
	{
		if(x[i] < 0)
		{
			printf("%d |", x[i]);
			n++;
				}	
	}
	
	printf("Foram digitados %d números pares\n", p);
	printf("Foram digitados %d números ímpares\n", im);
	printf("Foram digitados %d números negativos\n", n);
	
	return(0);
}

