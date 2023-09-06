package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection connectDB(){
        
        Connection conn;
        
        try {
        
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/leiloes",
                    "root",
                    "Dados.1gbm"
            );
            return conn;
            
        } catch (SQLException erro){
            System.out.println("Erro na classe Cenexao: " + erro.getMessage());
            return null;
        }
        
    }
    
}
