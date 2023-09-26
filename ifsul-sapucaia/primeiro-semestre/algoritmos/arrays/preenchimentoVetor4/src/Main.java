import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        int[] pares = new int[5];
        int[] impares = new int[5];
        int contadorPar = 0;
        int contadorImpar = 0;
        
        for (int i = 0; i < 15; i++) {
            int numero = keyboard.nextInt();
            
            if (numero % 2 == 0) {
                pares[contadorPar] = numero;
                if (contadorPar == 4) {
                    for(int j = 0; j < 5; j++) {
                        System.out.printf("par[%d] = %d\n", j, pares[j]);
                    }
                    contadorPar =- 1;
                }
                contadorPar++;
            }
            else {
                impares[contadorImpar] = numero;
                if (contadorImpar == 4) {
                    for(int j = 0; j < 5; j++) {
                        System.out.printf("impar[%d] = %d\n", j, impares[j]);
                    }
                    contadorImpar =- 1;
                }
                contadorImpar++;
            }
        }
        for (int i = 0; i < contadorImpar; i++) {
            System.out.printf("impar[%d] = %d\n", i, impares[i]);
        }
        for (int i = 0; i < contadorPar; i++) {
            System.out.printf("par[%d] = %d\n", i, pares[i]);
        }        

        keyboard.close();

    }
}
