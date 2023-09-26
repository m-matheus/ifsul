#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int kmi, kmf, v, media;

printf("Vamos calcular o consumo médio do seu combustível. Informe os dados a seguir:\n");

printf("Quilometragem inicial do automóvel (em km):\n");
scanf("%d", &kmi);

printf("Quilometragem final (em km):\n");
scanf("%d", &kmf);

printf("Volume de combustível consumido (em litros):\n");
scanf("%d", &v);

media = (kmf - kmi)/v;

printf("Media de consumo do automóvel: \n%d Km/l\n", media);

system("Pause");
return(0);
}

