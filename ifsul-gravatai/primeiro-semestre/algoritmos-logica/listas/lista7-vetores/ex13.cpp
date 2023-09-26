#include <stdio.h>
#include <locale.h>

main() {
setlocale(LC_ALL, "Portuguese");

	int x[10], i, soma, media;
	
	printf("Digite 10 valores: ");
	for(i = 0; i < 10; i++)
	{
		scanf("%d", &x[i]);
	}
	
	for(i = 0; i < 10; i++)
	{
		soma += x[i];
	}
	
	media = soma / 10;

	printf("A média é %d", media);
	
	return(0);
}
