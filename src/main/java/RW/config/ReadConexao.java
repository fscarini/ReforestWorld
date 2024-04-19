/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RW.config;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;

public class ReadConexao {

    private static final String AES = "AES";
    private static final String SECRET_KEY = "adsusjt123moocaa";
    private static final String FILE_PATH = "config.properties";

    public static void main(String[] args) throws Exception {
        // Ler os dados criptografados do arquivo
        byte[] encryptedData = Files.readAllBytes(Paths.get(FILE_PATH));

        // Criar a chave secreta
        Key secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), AES);

        // Criar e inicializar o cifrador
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Descriptografar os dados
        byte[] decryptedData = cipher.doFinal(encryptedData);

        // Converter os dados descriptografados de volta para uma string
        String decryptedString = new String(decryptedData);

        // Separar o login e a senha
        String[] partes = decryptedString.split(":");
        String host = partes[0];
        String port = partes[1];
        String user = partes[2];
        String password = partes[3];
        String database = partes[4];

        // Exibir os valores descriptografados
        System.out.println("host: " + host);
        System.out.println("port: " + port);
        System.out.println("user: " + user);
        System.out.println("password: " + password);
        System.out.println("database: " + database);
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + " , " + user + " , " + password;
        
    }
    
}
/*import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;

public class ReadConexao {

    private static final String AES = "AES";
    private static final String SECRET_KEY = "adsusjt123moocaa";
    private static final String FILE_PATH = "config.properties";

    public static String[] obterValoresConexao() throws Exception {
        // Ler os dados criptografados do arquivo
        byte[] encryptedData = Files.readAllBytes(Paths.get(FILE_PATH));

        // Criar a chave secreta
        Key secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), AES);

        // Criar e inicializar o cifrador
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Descriptografar os dados
        byte[] decryptedData = cipher.doFinal(encryptedData);

        // Converter os dados descriptografados de volta para uma string
        String decryptedString = new String(decryptedData);

        // Separar o login e a senha
        String[] partes = decryptedString.split(":");
        String host = partes[0];
        String port = partes[1];
        String user = partes[2];
        String password = partes[3];
        String database = partes[4];

        // Retornar os valores de conexão como uma matriz de strings
        return new String[]{host, port, user, password, database};
    }
    
}
*/