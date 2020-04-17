package dao;

import factory.ConnectionFactory;
import model.User;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaomiranda
 */
public class UserDAO {

    private Connection connection;
    Long id;
    String nome;
    String idade;
    String genero;
    String email;
    String tel;
    String classe;
    String estadocivil;
    String profissao;
    String filhos;
    String participacao;
    String tipo;
    String observacao;
    String rg;
    String bairro;
    String cidade;
    String estado;
    String rua;

    public UserDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean add(User usuario) {

        String sql = "INSERT INTO usuario(" + "nome," + "idade," + "genero," + "email," + "tel," + "classe,"
                + "estadocivil," + "profissao," + "filhos," + "participacao," + "tipo," + "observacao," + "rg,"
                + "bairro," + "cidade," + "estado," + "rua)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getIdade());
            stmt.setString(3, usuario.getGenero());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getTel());
            stmt.setString(6, usuario.getClasse());
            stmt.setString(7, usuario.getEstadocivil());
            stmt.setString(8, usuario.getProfissao());
            stmt.setString(9, usuario.getFilhos());
            stmt.setString(10, usuario.getParticipacao());
            stmt.setString(11, usuario.getTipo());
            stmt.setString(12, usuario.getObservacao());
            stmt.setString(13, usuario.getRg());
            stmt.setString(14, usuario.getBairro());
            stmt.setString(15, usuario.getCidade());
            stmt.setString(16, usuario.getEstado());
            stmt.setString(17, usuario.getRua());

            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException u) {
            throw new RuntimeException(u);

        }
    }

    public List<User> findAll() {

        String sql = "SELECT * FROM usuario;";

        ResultSet rs = null;
        List<User> lista = new ArrayList<>();

        try {
            PreparedStatement psm = connection.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()) {
                User usuario = new User();
                usuario.setNome(rs.getString("nome"));
                usuario.setIdade(rs.getString("idade"));
                usuario.setGenero(rs.getString("genero"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTel(rs.getString("tel"));
                usuario.setClasse(rs.getString("classe"));
                usuario.setEstadocivil(rs.getString("estadocivil"));
                usuario.setProfissao(rs.getString("profissao"));
                usuario.setFilhos(rs.getString("filhos"));
                usuario.setParticipacao(rs.getString("participacao"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setObservacao(rs.getString("observacao"));
                usuario.setRg(rs.getString("rg"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setRua(rs.getString("rua"));
                lista.add(usuario);
            }
            psm.close();
        } catch (SQLException ex) {
            System.err.println("Erro");
            lista = null;

        }
        return lista;
    }

    public void update(User usuario) {

        String sql = "UPDATE usuario SET nome = ?, idade = ?, genero = ?, email = ?, tel = ?, classe = ?, estadocivil = ?, profissao = ?, filhos = ?, participacao = ?, tipo = ?, observacao = ?, rg = ?, bairro = ?, cidade = ?, estado = ?,rua = ? WHERE id = ?;";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getIdade());
            stmt.setString(3, usuario.getGenero());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getTel());
            stmt.setString(6, usuario.getClasse());
            stmt.setString(7, usuario.getEstadocivil());
            stmt.setString(8, usuario.getProfissao());
            stmt.setString(9, usuario.getFilhos());
            stmt.setString(10, usuario.getParticipacao());
            stmt.setString(11, usuario.getTipo());
            stmt.setString(12, usuario.getObservacao());
            stmt.setString(13, usuario.getRg());
            stmt.setString(14, usuario.getBairro());
            stmt.setString(15, usuario.getCidade());
            stmt.setString(16, usuario.getEstado());
            stmt.setString(17, usuario.getRua());
            stmt.setLong(18, usuario.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void delete() {

    }

}
