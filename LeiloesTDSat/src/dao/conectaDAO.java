package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
    
    public Connection connectDB(){
        
        Connection conn = null;
        
        try {
        
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ base_empresa", // linha de conexao
                    "root", // usuario do mysql
                    "Dados.1gbm" // senha do mysql
            );
            return conn;
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }
    
}
