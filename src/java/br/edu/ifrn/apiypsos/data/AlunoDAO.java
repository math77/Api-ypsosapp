/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.apiypsos.data;

import br.edu.ifrn.apiypsos.domain.Aluno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matheus
 */
public class AlunoDAO {

    public static boolean createAluno(Aluno aluno) {
        Connection conn = ConnectionFactory.conectar();
        boolean inseriu = false;

        String query = "INSERT INTO Aluno(nome, email, senha, cpf, sexo, data_nascimento, data_ingresso) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getEmail());
            ps.setString(3, aluno.getSenha());
            ps.setString(4, aluno.getCpf());
            ps.setString(5, aluno.getSexo());
            ps.setDate(6, (Date) aluno.getDataNascimento());
            ps.setDate(7, (Date) aluno.getDataIngresso());

            inseriu = (ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.desconectar();
        }

        return inseriu;
    }
    
    public static boolean login(Aluno aluno){
        Connection conn = ConnectionFactory.conectar();
        boolean existe = false;
        
        String query = "SELECT nome FROM Aluno WHERE email = ? AND senha = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, aluno.getEmail());
            ps.setString(2, aluno.getSenha());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                existe = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.desconectar();
        }
        
        return existe;
    }

    public static List<Aluno> listarAlunos() {

        List<Aluno> alunos = new ArrayList<>();

        String query = "SELECT email, nome FROM Aluno;";

        Connection con = ConnectionFactory.conectar();

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setEmail(rs.getString("email"));
                aluno.setNome(rs.getString("nome"));

                alunos.add(aluno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.desconectar();
        }

        return alunos;
    }
    
    public static boolean verificaToken(String token) {
        Connection con = ConnectionFactory.conectar();
        boolean existe = false;

        String query = "SELECT api_token FROM Aluno WHERE api_token = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, token);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.desconectar();
        }
        
        return existe;
    }
    
    public static boolean saveToken(String token, String email){
        Connection conn = ConnectionFactory.conectar();
        boolean salvo = false;

        String query = "UPDATE Aluno SET api_token = ? WHERE email = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, token);
            ps.setString(2, email);

            salvo = (ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.desconectar();
        }

        return salvo;
    }
}
