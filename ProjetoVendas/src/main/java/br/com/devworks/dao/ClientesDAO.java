/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devworks.dao;

import br.com.devworks.jdbc.ModuloConexao;
import br.com.devworks.model.Clientes;
import br.com.devworks.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz
 */
public class ClientesDAO {
    
    private Connection con;
    
    public ClientesDAO(){
    
    this.con = new ModuloConexao().getConnection();
    
    }
    
    
    public void cadastrarCliente(Clientes obj){
        
        try {
            
            String sql = "insert into tb_clientes (nome, rg, cpf, email, "
                    + "telefone, celular, cep, endereco, numero, complemento, "
                    + "bairro, cidade, estado)"
                    + "values (?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRg());
            pst.setString(3, obj.getCpf());
            pst.setString(4, obj.getEmail());
            pst.setString(5, obj.getTelefone());
            pst.setString(6, obj.getCelular());
            pst.setString(7, obj.getCep());
            pst.setString(8, obj.getEndereco());
            pst.setInt(9, obj.getNumero());
            pst.setString(10, obj.getComplemento());
            pst.setString(11, obj.getBairro());
            pst.setString(12, obj.getCidade());
            pst.setString(13, obj.getUf());
            
            pst.execute();
            pst.close();
            
            
            JOptionPane.showMessageDialog(null, "cadastrado com sucesso!");
            
            
            
            
            
            
            
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        
        
        }
        
    }
    
    
    
    
    public void alterarCliente(Clientes obj){
        
           try {
            
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, "
                    + "telefone=?, celular=?, cep=?, endereco=?, numero=?, "
                    + "complemento=?, bairro=?"
                    + ", cidade=?, estado=? where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRg());
            pst.setString(3, obj.getCpf());
            pst.setString(4, obj.getEmail());
            pst.setString(5, obj.getTelefone());
            pst.setString(6, obj.getCelular());
            pst.setString(7, obj.getCep());
            pst.setString(8, obj.getEndereco());
            pst.setInt(9, obj.getNumero());
            pst.setString(10, obj.getComplemento());
            pst.setString(11, obj.getBairro());
            pst.setString(12, obj.getCidade());
            pst.setString(13, obj.getUf());
            pst.setInt(14,obj.getId());
            
            pst.execute();
            pst.close();
            
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            
            
            
            
            
            
            
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        
        
        }
        
    }
    
    
    
    
    public void excluirCliente(Clientes obj){
         try {
            
            String sql = "delete from tb_clientes where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, obj.getId());
            
            pst.execute();
            pst.close();
            
            
            JOptionPane.showMessageDialog(null, "excluido com sucesso!");
            
            
            
            
            
            
            
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        
        
        }
    }
    
    
  
    
    public List<Clientes> listarClientes(){
    
        try {
            
            List<Clientes> lista = new ArrayList<>();
            String sql= "select * from tb_clientes";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
            
            Clientes obj = new Clientes();
            
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setRg(rs.getString("rg"));
            obj.setCpf(rs.getString("cpf"));
            obj.setEmail(rs.getString("email"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setCelular(rs.getString("celular"));
            obj.setCep(rs.getString("cep"));
            obj.setEndereco(rs.getString("endereco"));
            obj.setNumero(rs.getInt("numero"));
            obj.setComplemento(rs.getString("complemento"));
            obj.setBairro(rs.getString("bairro"));
            obj.setCidade(rs.getString("cidade"));
            obj.setUf(rs.getString("estado"));
            
            lista.add(obj);
            
            
            
            }
            
           return lista;
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }
    
    
    
    
    public List<Clientes> buscaClientePorNome(String nome){
    
       try {
            
            List<Clientes> lista = new ArrayList<>();
            String sql= "select * from tb_clientes where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
            
            Clientes obj = new Clientes();
            
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setRg(rs.getString("rg"));
            obj.setCpf(rs.getString("cpf"));
            obj.setEmail(rs.getString("email"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setCelular(rs.getString("celular"));
            obj.setCep(rs.getString("cep"));
            obj.setEndereco(rs.getString("endereco"));
            obj.setNumero(rs.getInt("numero"));
            obj.setComplemento(rs.getString("complemento"));
            obj.setBairro(rs.getString("bairro"));
            obj.setCidade(rs.getString("cidade"));
            obj.setUf(rs.getString("estado"));
            
            lista.add(obj);
            
            
            
            }
            
           return lista;
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }
    
    
    
    
    public Clientes consultaPorNome(String nome){
        try {
 
            String sql= "select * from tb_clientes where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();   
            Clientes obj = new Clientes();

             if(rs.next()){
            
            
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setRg(rs.getString("rg"));
            obj.setCpf(rs.getString("cpf"));
            obj.setEmail(rs.getString("email"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setCelular(rs.getString("celular"));
            obj.setCep(rs.getString("cep"));
            obj.setEndereco(rs.getString("endereco"));
            obj.setNumero(rs.getInt("numero"));
            obj.setComplemento(rs.getString("complemento"));
            obj.setBairro(rs.getString("bairro"));
            obj.setCidade(rs.getString("cidade"));
            obj.setUf(rs.getString("estado"));
            
            
            
            
            }
             return obj;
        
        
        
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Erro, cliente não encontrado,"
                    + "para mais detalhes segue o codigo detalhado: \n"+ e);
            return null;
            
            
        }
    }
    
    
    
    
    
	
	  public Clientes buscaCep(String cep) {
       
              WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
	
	
    
    
    
    
    
}
