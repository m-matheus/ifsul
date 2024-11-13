package com.matheus.demo.decrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Main {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            
            // Ler o arquivo de chave cifrada
            byte[] encryptedKey = Files.readAllBytes(Paths.get("C:\\Users\\Mmatt\\OneDrive\\Documentos\\GitHub\\ifsul\\quarto-semestre\\fundamentos-segurança\\w1\\demo\\src\\main\\java\\com\\matheus\\demo\\files/keys_enc/20231SS.ADS_J0003_key.enc"));

            // Decifrar a chave simétrica usando RSA
            byte[] symmetricKey = decryptRSA(encryptedKey, privateKey);

            // Configurar os parâmetros para Chacha20 a partir do arquivo 'dados.txt'
            byte[] nonce = readNonceFromFile("C:\\Users\\Mmatt\\OneDrive\\Documentos\\GitHub\\ifsul\\quarto-semestre\\fundamentos-segurança\\w1\\demo\\src\\main\\java\\com\\matheus\\demo\\files/dados.txt");
            Cipher chacha20 = Cipher.getInstance("ChaCha20");
            SecretKeySpec keySpec = new SecretKeySpec(symmetricKey, "ChaCha20");

            // Inicializar o cipher
            chacha20.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(nonce));

            // Ler o arquivo cifrado e decifrar
            byte[] encryptedMsg = Files.readAllBytes(Paths.get("C:\\Users\\Mmatt\\OneDrive\\Documentos\\GitHub\\ifsul\\quarto-semestre\\fundamentos-segurança\\w1\\demo\\src\\main\\java\\com\\matheus\\demo\\files/msg_fil_enc/20231SS.ADS_J0003_msgfile.enc"));
            byte[] decryptedMsg = chacha20.doFinal(encryptedMsg);

            // Salvar o conteúdo decifrado em um arquivo .txt
            String outputFilePath = "C:\\Users\\Mmatt\\OneDrive\\Documentos\\GitHub\\ifsul\\quarto-semestre\\fundamentos-segurança\\w1\\demo\\src\\main\\java\\com\\matheus\\demo\\files/saida_decifrada.txt";
            Files.write(Paths.get(outputFilePath), decryptedMsg);

            // Imprimir a confirmação e o conteúdo decifrado
            System.out.println("Arquivo decifrado com sucesso: " + outputFilePath);
            System.out.println("Conteúdo: " + new String(decryptedMsg));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] decryptRSA(byte[] data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    private static byte[] readNonceFromFile(String filePath) throws IOException {
        // Ler e processar o arquivo de parâmetros 'dados.txt'
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        // Assumindo que a primeira linha contém o nonce em hexadecimal
        String hexNonce = lines.get(0).split(":")[1].trim();
        return hexStringToByteArray(hexNonce);
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
