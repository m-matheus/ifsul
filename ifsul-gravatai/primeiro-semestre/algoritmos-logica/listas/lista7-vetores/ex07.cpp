#include <stdio.h>
#include <locale.h>

main() {
setlocale(LC_ALL, "Portuguese");

	int x[10], i;

    printf("Digite 10 valores:\n");
    
	for (i = 0; i < 10; i++) 
	{
        scanf("%d", &x[i]);
    }
    
	printf("\nValores armazenados nos índices pares:\n");
    
	for (i = 0; i < 10; i++) 
	{
        if (i % 2 == 0) 
		{
            printf("%d\n", x[i]);
        }
    }
    
    return 0;
}

