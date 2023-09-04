package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {
    
    public Connection connectDB(){
        
        Connection conn;
        
        try {
        
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/leiloes", // linha de conexao
                    "root", // usuario do mysql
                    "Dados.1gbm" // senha do mysql
            );
            return conn;
            
        } catch (SQLException erro){
            System.out.println("Erro ao conectar: " + erro.getMessage());
            return null;
        }
        
    }
    
}
