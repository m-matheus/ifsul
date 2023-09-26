#include <stdio.h>
#include <locale.h>

int main()
{
	setlocale(LC_ALL, "Portuguese");
    
	int num[10];
    int i;
	
	printf("Digite 10 números: \n");
    for(i=0;i<=9;i++)
    	scanf("%i", &num[i]);
    printf("O primeiro número é %d e o quinto número é %d.", num[0], num[4]);

    return 0;
}
