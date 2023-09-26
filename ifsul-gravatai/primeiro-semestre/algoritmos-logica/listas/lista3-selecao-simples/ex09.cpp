#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int n1, n2, n3;

printf("Digite três números inteiros: ");
scanf("%d %d %d", &n1, &n2, &n3);
if (n1>n2 && n1>n3) printf("%d\n", n1);
else if (n2>n1 && n2>n3) printf("%d\n", n2);
else if (n3>n1 && n3>n2) printf("%d\n", n3);

system("Pause");
return(0);
}

