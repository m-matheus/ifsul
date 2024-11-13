package com.matheus.demo.decrypt;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Ler o arquivo de chave cifrada
            byte[] encryptedKey = Files.readAllBytes(Paths.get("C:\\Users\\Mmatt\\OneDrive\\Documentos\\GitHub\\ifsul\\quarto-semestre\\fundamentos-segurança\\w1\\demo\\src\\main\\java\\com\\matheus\\demo\\files/keys_enc/20231SS.ADS_J0003_key.enc"));

            // Carregar a chave pública
            PublicKey publicKey = loadPublicKey("C:\\Users\\Mmatt\\OneDrive\\Documentos\\GitHub\\ifsul\\quarto-semestre\\fundamentos-segurança\\w1\\demo\\src\\main\\java\\com\\matheus\\demo\\files/public.key");

            // Decifrar a chave simétrica usando RSA
            byte[] symmetricKey = decryptRSA(encryptedKey, publicKey);

            // Configurar os parâmetros para Chacha20
            String nonceBase64 = "qZqoOT440YFumdR0";
            byte[] nonce = Base64.getDecoder().decode(nonceBase64);
            int counter = 0;
            Cipher chacha20 = Cipher.getInstance("ChaCha20");
            SecretKeySpec keySpec = new SecretKeySpec(symmetricKey, "ChaCha20");

            ChaCha20ParameterSpec parameterSpec = new ChaCha20ParameterSpec(nonce, counter);
            chacha20.init(Cipher.DECRYPT_MODE, keySpec, parameterSpec);

            // Ler o arquivo cifrado e decifrar
            byte[] encryptedMsg = Files.readAllBytes(Paths.get("C:\\Users\\Mmatt\\OneDrive\\Documentos\\GitHub\\ifsul\\quarto-semestre\\fundamentos-segurança\\w1\\demo\\src\\main\\java\\com\\matheus\\demo\\files/msg_file_enc/20231SS.ADS_J0003_msgfile.enc"));
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

    private static byte[] decryptRSA(byte[] data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    private static PublicKey loadPublicKey(String filePath) throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(filePath));
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(spec);
    }
}
