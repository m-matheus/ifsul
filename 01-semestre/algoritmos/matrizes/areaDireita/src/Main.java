import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        double[][] M = new double[12][12];
        String O = keyboard.next();
        double soma = 0;
        double media = 0;

        // preenchendo a matriz
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                M[i][j] = keyboard.nextDouble();
            }
        }

        // caso seja soma 'S'
        if (O.equalsIgnoreCase("S")) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    if ((j > 6) && (i < j) && (i + j >= 12)) {
                        soma += M[i][j];
                    }
                }
            }

            System.out.println(soma);
        }
        // caso seja media 'M'
        else if (O.equalsIgnoreCase("M")) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; i++) {
                    if ((j > 6) && (i < j) && (i + j >= 12)) {
                        soma += M[i][j];
                    }
                }
            }

            media = (soma) / 144.0;

            System.out.println(media);
        }
        // caso o usuario nao digite s ou m no começo
        else {
            System.out.println("Você precisa digitar uma operção entre S (soma) ou M (média).");
        }

        keyboard.close();
    }
}
