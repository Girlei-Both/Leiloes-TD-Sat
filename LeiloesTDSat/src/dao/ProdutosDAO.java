package dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import beans.Produtos;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<Produtos> listagem = new ArrayList<>();
    
    public void cadastrarProduto (Produtos produto){
        
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<Produtos> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

