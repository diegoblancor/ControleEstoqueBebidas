package dao;

public class Conexao {
import model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public void inserir(Categoria categoria) {
        String sql = "INSERT INTO categoria (nome, tamanho, embalagem) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getTamanho());
            stmt.setString(3, categoria.getEmbalagem());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                categoria.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir categoria: " + e.getMessage());
        }
    }

    public Categoria buscarPorNome(String nome) {
        String sql = "SELECT * FROM categoria WHERE nome = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getString("nome"),
                        rs.getString("tamanho"),
                        rs.getString("embalagem")
                );
                categoria.setId(rs.getInt("id"));
                return categoria;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar categoria: " + e.getMessage());
        }

        return null;
    }

    public List<Categoria> listarCategorias() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getString("nome"),
                        rs.getString("tamanho"),
                        rs.getString("embalagem")
                );
                categoria.setId(rs.getInt("id"));
                lista.add(categoria);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar categorias: " + e.getMessage());
        }

        return lista;
    }
}

    
}
