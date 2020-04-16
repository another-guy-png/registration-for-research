/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import model.User;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author joaomiranda
 */
public class UserDAO {

    private Connection connection;
    Long id;
    String nome;
    String idade;
    String cpf;
    String genero;
    String email;
    String tel;
    String classe;
    String estadocivil;
    String profissao;
    String filhos;
    String participacao;
    String endereco;
    String tipo;
    String observacao;

    public UserDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void add(User usuario) {
        
        String sql = "INSERT INTO usuario("
                + "nome,"
                + "idade,"
                + "cpf,"
                + "genero,"
                + "email,"
                + "tel,"
                + "classe,"
                + "estadocivil,"
                + "profissao,"
                + "filhos,"
                + "participacao"
                + ",endereco,"
                + "tipo,"
                + "observacao)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getIdade());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getGenero());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTel());
            stmt.setString(7, usuario.getClasse());
            stmt.setString(8, usuario.getEstadocivil());
            stmt.setString(9, usuario.getProfissao());
            stmt.setString(10, usuario.getFilhos());
            stmt.setString(11, usuario.getParticipacao());
            stmt.setString(12, usuario.getEndereco());
            stmt.setString(13, usuario.getTipo());
            stmt.setString(14, usuario.getObservacao());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

}
