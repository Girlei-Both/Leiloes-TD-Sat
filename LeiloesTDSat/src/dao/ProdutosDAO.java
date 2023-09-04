package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dto.ProdutosDTO;

public class ProdutosDAO {
    
    String sql = "";
    private conectaDAO dao;
    private Connection conn;
    
    PreparedStatement prepstm;
    //ResultSet resultset;
    
    public ProdutosDAO(){
        this.dao = new conectaDAO();
        this.conn = (Connection) this.dao.connectDB();
    }
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        sql = "INSERT INTO leiloes.produtos (nome, valor, status) VALUES "
            + "(?, ?, ?)";
        
        try {
            prepstm = (PreparedStatement) this.conn.prepareStatement(sql);
            prepstm.setString(1, produto.getNome());
            prepstm.setInt(2, produto.getValor());
            prepstm.setString(3, produto.getStatus());
            prepstm.execute();

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
        
    }

}

