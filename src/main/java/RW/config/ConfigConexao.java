/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RW.config;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.Key;

public class ConfigConexao {

    private static final String AES = "AES";
    private static final String SECRET_KEY = "adsusjt123moocaa";
    private static final String FILE_PATH = "config.properties";

    public static void main(String[] args) throws Exception {

        String host = "mysql-260935f7-dartvader.b.aivencloud.com";
        String port = "16916";
        String user = "avnadmin";
        String password = "AVNS_vwM_kVHzcyVDkeI8bb5";
        String database = "db_rwc";
    
        // Concatenando login e senha em uma string
        String dados = host + ":" + port + ":" + user + ":" + password + ":" + database;

        // Criar a chave secreta
        Key secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), AES);

        // Criar e inicializar o cifrador
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Criptografar os dados
        byte[] encryptedData = cipher.doFinal(dados.getBytes());

        // Escrever os dados criptografados para o arquivo
        Files.write(Paths.get(FILE_PATH), encryptedData, StandardOpenOption.CREATE);
    }
}