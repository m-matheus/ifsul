#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int n1, n2;

printf("Digite dois números inteiros: ");
scanf("%d %d", &n1, &n2);
if (n1>n2) printf("%d\n", n1);
else printf("%d\n", n2);

system("Pause");
return(0);
}

