package RW.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Conexao {
    
    private static final String AES = "AES";
    private static final String SECRET_KEY = "adsusjt123moocaa";
    private static final String FILE_PATH = "config.properties";

    public Connection getConnection() {
        try {
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

            // Construir a URL de conexão
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

            // Estabelecer a conexão
            Connection conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | SQLException e) {
            // Tratamento de exceções
            e.printStackTrace();
            return null; // ou outra ação apropriada de tratamento de erro
        }
    }
}



