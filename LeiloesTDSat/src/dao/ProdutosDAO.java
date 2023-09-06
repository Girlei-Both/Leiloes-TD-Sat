package dao;

import conexao.Conexao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import beans.Produtos;

public class ProdutosDAO {
    
    String sql = "";
    private Conexao dao;
    private Connection conn;
    
    PreparedStatement prepstm;
    //ResultSet resultset;
    
    public ProdutosDAO(){
        this.dao = new Conexao();
        this.conn = (Connection) this.dao.connectDB();
    }
    
    public void cadastrarProduto (Produtos produto){
        
        sql = "INSERT INTO leiloes.produtos (nome, valor, status) VALUES "
            + "(?, ?, ?)";
        
        try {
            prepstm = (PreparedStatement) this.conn.prepareStatement(sql);
            prepstm.setString(1, produto.getNome());
            prepstm.setInt(2, produto.getValor());
            prepstm.setString(3, produto.getStatus());
            prepstm.execute();

        } catch (Exception erro) {
            System.out.println("Erro na classe ProdutosDAO: " + erro.getMessage());
        }
        
    }

}

