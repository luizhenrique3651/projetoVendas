/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devworks.dao;

import br.com.devworks.jdbc.ModuloConexao;
import br.com.devworks.model.Funcionarios;
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
public class FuncionariosDAO {
    //conexao com banco
    
    private Connection con;
    
    public FuncionariosDAO(){
    
    this.con = new ModuloConexao().getConnection();
    
    }
    
    
    //metodo para cadastrar
    public void cadastrarFuncionarios(Funcionarios obj){
        
        try {
            
            String sql = "insert into tb_funcionarios (nome, rg, cpf, email,senha,"
                    + "cargo, nivel_acesso, telefone, celular, cep, endereco,"
                    + " numero, complemento, bairro, cidade, estado)"
                    + "values (?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRg());
            pst.setString(3, obj.getCpf());
            pst.setString(4, obj.getEmail());
            pst.setString(5, obj.getSenha());
            pst.setString(6, obj.getCargo());
            pst.setString(7, obj.getNivel_acesso());
            pst.setString(8, obj.getTelefone());
            pst.setString(9, obj.getCelular());
            pst.setString(10, obj.getCep());
            pst.setString(11, obj.getEndereco());
            pst.setInt(12, obj.getNumero());
            pst.setString(13, obj.getComplemento());
            pst.setString(14, obj.getBairro());
            pst.setString(15, obj.getCidade());
            pst.setString(16, obj.getUf());
            
            pst.execute();
            pst.close();
            
            
            JOptionPane.showMessageDialog(null, "cadastrado com sucesso!");
            
            
            
            
            
            
            
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        
        
        }
        
    }
    
    
    
    public List<Funcionarios> listarFuncionarios(){
    
        try {
            
            List<Funcionarios> lista = new ArrayList<>();
            String sql= "select * from tb_funcionarios";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
            
            Funcionarios obj = new Funcionarios();
            
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setRg(rs.getString("rg"));
            obj.setCpf(rs.getString("cpf"));
            obj.setEmail(rs.getString("email"));
            obj.setSenha(rs.getString("senha"));
            obj.setCargo(rs.getString("cargo"));
            obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
    
    
    
    
    public Funcionarios consultaPorNome(String nome){
        try {
 
            String sql= "select * from tb_funcionarios where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();   
            Funcionarios obj = new Funcionarios();

             if(rs.next()){
            
            
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setRg(rs.getString("rg"));
            obj.setCpf(rs.getString("cpf"));
            obj.setEmail(rs.getString("email"));
            obj.setSenha(rs.getString("senha"));
            obj.setCargo(rs.getString("cargo"));
            obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
    
    
    
     public List<Funcionarios> buscaFuncionarioPorNome(String nome){
    
       try {
            
            List<Funcionarios> lista = new ArrayList<>();
            String sql= "select * from tb_funcionarios where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
            
            Funcionarios obj = new Funcionarios();
            
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setRg(rs.getString("rg"));
            obj.setCpf(rs.getString("cpf"));
            obj.setEmail(rs.getString("email"));
            obj.setSenha(rs.getString("senha"));
            obj.setCargo(rs.getString("cargo"));
            obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
     
     
     
       
    public void alterarFuncionario(Funcionarios obj){
        
           try {
            
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, "
                    + "senha=?, cargo=?, nivel_acesso=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, "
                    + "complemento=?, bairro=?"
                    + ", cidade=?, estado=? where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRg());
            pst.setString(3, obj.getCpf());
            pst.setString(4, obj.getEmail());
            pst.setString(5, obj.getSenha());
            pst.setString(6, obj.getCargo());
            pst.setString(7, obj.getNivel_acesso());
            pst.setString(8, obj.getTelefone());
            pst.setString(9, obj.getCelular());
            pst.setString(10, obj.getCep());
            pst.setString(11, obj.getEndereco());
            pst.setInt(12, obj.getNumero());
            pst.setString(13, obj.getComplemento());
            pst.setString(14, obj.getBairro());
            pst.setString(15, obj.getCidade());
            pst.setString(16, obj.getUf());
            pst.setInt(17,obj.getId());
            
            pst.execute();
            pst.close();
            
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            
            
            
            
            
            
            
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        
        
        }
        
    }
    
    
    
    
    public void excluirFuncionario(Funcionarios obj){
         try {
            
            String sql = "delete from tb_funcionarios where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, obj.getId());
            
            pst.execute();
            pst.close();
            
            
            JOptionPane.showMessageDialog(null, "excluido com sucesso!");
            
            
            
            
            
            
            
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        
        
        }
    }
    
    
    
    
}
