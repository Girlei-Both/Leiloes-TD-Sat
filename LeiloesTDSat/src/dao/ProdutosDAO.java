package dao;

import conexao.Conexao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import beans.Produtos;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {
    
    String sql = "";
    private Conexao dao;
    private Connection conn;
    
    PreparedStatement prepstm;
    ResultSet resultset;
    
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
            System.out.println("Erro na classe ProdutosDAO (Cadastrar): " + erro.getMessage());
        }
        
    }
    
    //LISTAR TODOS OS REGISTROS
    public List<Produtos> listarProdutos() {
        
        sql = "SELECT * FROM leiloes.produtos";

        try {
            prepstm = (PreparedStatement) this.conn.prepareStatement(sql);
            resultset = prepstm.executeQuery();            

            List<Produtos> todosProdutos = new ArrayList<>();

            while (resultset.next()) {
                
                Produtos produtos = new Produtos();
                
                produtos.setId(resultset.getInt("id"));
                produtos.setNome(resultset.getString("nome"));
                produtos.setValor(resultset.getInt("valor"));
                produtos.setStatus(resultset.getString("status"));

                todosProdutos.add(produtos);    
            }
            return todosProdutos;
            
        } catch (Exception erro) {
            System.out.println("Erro na classe ProdutosDAO (Listar): " + erro.getMessage());
            return null;
        }
        
    }
    
    public void venderProdutos (Produtos produto){
        
        //deve atualizar o status de um produto para “Vendido”.
        sql = "UPDATE leiloes.produtos SET status=? WHERE id=?";
        
        try {
            
            prepstm = (PreparedStatement) conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            prepstm.setString(1, produto.getStatus());
            prepstm.setInt(2, produto.getId());
            prepstm.execute();

        } catch (Exception erro) {
            System.out.println("Erro na classe ProdutosDAO (Vender): " + erro.getMessage());
        }
        
    }
    
    public List<Produtos> listarProdutosVendidos() {
        //deve buscar todos os produtos no banco de dados com o status “Vendido”
        sql = "SELECT * FROM leiloes.produtos WHERE status='Vendido'";

        try {
            prepstm = (PreparedStatement) this.conn.prepareStatement(sql);
            resultset = prepstm.executeQuery();            

            List<Produtos> todosProdutos = new ArrayList<>();

            while (resultset.next()) {
                
                Produtos produtos = new Produtos();
                
                produtos.setId(resultset.getInt("id"));
                produtos.setNome(resultset.getString("nome"));
                produtos.setValor(resultset.getInt("valor"));
                produtos.setStatus(resultset.getString("status"));

                todosProdutos.add(produtos);    
            }
            return todosProdutos;
            
        } catch (Exception erro) {
            System.out.println("Erro na classe ProdutosDAO (Listar): " + erro.getMessage());
            return null;
        }
    }

}

