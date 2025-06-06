package dao;

<<<<<<< HEAD
=======
public class ProdutoDAO {package dao;

>>>>>>> dc1c8f481c3e4939fb40e306aa774e09f2f799df
import model.Categoria;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

<<<<<<< HEAD
 private final CategoriaDAO categoriaDAO = new CategoriaDAO();

 public void inserir(Produto produto) {
 // Verifica se a categoria já existe, senão insere
 Categoria categoriaExistente = categoriaDAO.buscarPorNome(produto.getCategoria().getNome());
 if (categoriaExistente == null) {
 categoriaDAO.inserir(produto.getCategoria());
 } else {
 produto.setCategoria(categoriaExistente);
 }

 String sql = "INSERT INTO produto (nome, preco_unitario, unidade, quantidade, quantidade_minima, quantidade_maxima, categoria_id) " +
"VALUES (?, ?, ?, ?, ?, ?, ?)";

 try (Connection conn = Conexao.getConexao();
PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

 stmt.setString(1, produto.getNome());
 stmt.setDouble(2, produto.getPrecoUnitario());
 stmt.setString(3, produto.getUnidade());
 stmt.setInt(4, produto.getQuantidade());
 stmt.setInt(5, produto.getQuantidadeMinima());
 stmt.setInt(6, produto.getQuantidadeMaxima());
 stmt.setInt(7, produto.getCategoria().getId());

 stmt.executeUpdate();

 ResultSet rs = stmt.getGeneratedKeys();
 if (rs.next()) {
 produto.setId(rs.getInt(1));
 }

 } catch (SQLException e) {
 System.out.println("Erro ao inserir produto: " + e.getMessage());
 }
 }

 public Produto buscarPorNome(String nome) {
 String sql = "SELECT p.*, c.nome AS cat_nome, c.tamanho, c.embalagem, c.id AS cat_id " +
"FROM produto p JOIN categoria c ON p.categoria_id = c.id WHERE p.nome = ?";

 try (Connection conn = Conexao.getConexao();
PreparedStatement stmt = conn.prepareStatement(sql)) {

 stmt.setString(1, nome);
 ResultSet rs = stmt.executeQuery();

 if (rs.next()) {
 Categoria categoria = new Categoria(
 rs.getString("cat_nome"),
 rs.getString("tamanho"),
 rs.getString("embalagem")
 );
 categoria.setId(rs.getInt("cat_id"));

 Produto produto = new Produto(
 rs.getString("nome"),
 rs.getDouble("preco_unitario"),
 rs.getString("unidade"),
 rs.getInt("quantidade"),
 rs.getInt("quantidade_minima"),
 rs.getInt("quantidade_maxima"),
 categoria
 );
 produto.setId(rs.getInt("id"));
 return produto;
 }

 } catch (SQLException e) {
 System.out.println("Erro ao buscar produto: " + e.getMessage());
 }

 return null;
 }

 public List<Produto> listarTodos() {
 List<Produto> lista = new ArrayList<>();
 String sql = "SELECT p.*, c.nome AS cat_nome, c.tamanho, c.embalagem, c.id AS cat_id " +
"FROM produto p JOIN categoria c ON p.categoria_id = c.id ORDER BY p.nome";

 try (Connection conn = Conexao.getConexao();
PreparedStatement stmt = conn.prepareStatement(sql);
ResultSet rs = stmt.executeQuery()) {

 while (rs.next()) {
 Categoria categoria = new Categoria(
 rs.getString("cat_nome"),
 rs.getString("tamanho"),
 rs.getString("embalagem")
 );
 categoria.setId(rs.getInt("cat_id"));

 Produto produto = new Produto(
 rs.getString("nome"),
 rs.getDouble("preco_unitario"),
 rs.getString("unidade"),
 rs.getInt("quantidade"),
 rs.getInt("quantidade_minima"),
 rs.getInt("quantidade_maxima"),
 categoria
 );
 produto.setId(rs.getInt("id"));

 lista.add(produto);
 }

 } catch (SQLException e) {
 System.out.println("Erro ao listar produtos: " + e.getMessage());
 }

 return lista;
 }

 public void atualizarQuantidade(String nomeProduto, int novaQuantidade) {
 String sql = "UPDATE produto SET quantidade = ? WHERE nome = ?";

 try (Connection conn = Conexao.getConexao();
PreparedStatement stmt = conn.prepareStatement(sql)) {

 stmt.setInt(1, novaQuantidade);
 stmt.setString(2, nomeProduto);
 stmt.executeUpdate();

 } catch (SQLException e) {
 System.out.println("Erro ao atualizar quantidade: " + e.getMessage());
 }
 }

 public void reajustarPrecos(double percentual) {
 String sql = "UPDATE produto SET preco_unitario = preco_unitario * (1 + ? / 100)";

 try (Connection conn = Conexao.getConexao();
PreparedStatement stmt = conn.prepareStatement(sql)) {

 stmt.setDouble(1, percentual);
 stmt.executeUpdate();

 } catch (SQLException e) {
 System.out.println("Erro ao reajustar preços: " + e.getMessage());
 }
 }
}
=======
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();

    public void inserir(Produto produto) {
        // Verifica se a categoria já existe, senão insere
        Categoria categoriaExistente = categoriaDAO.buscarPorNome(produto.getCategoria().getNome());
        if (categoriaExistente == null) {
            categoriaDAO.inserir(produto.getCategoria());
        } else {
            produto.setCategoria(categoriaExistente);
        }

        String sql = "INSERT INTO produto (nome, preco_unitario, unidade, quantidade, quantidade_minima, quantidade_maxima, categoria_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoUnitario());
            stmt.setString(3, produto.getUnidade());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setInt(5, produto.getQuantidadeMinima());
            stmt.setInt(6, produto.getQuantidadeMaxima());
            stmt.setInt(7, produto.getCategoria().getId());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                produto.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public Produto buscarPorNome(String nome) {
        String sql = "SELECT p.*, c.nome AS cat_nome, c.tamanho, c.embalagem, c.id AS cat_id " +
                     "FROM produto p JOIN categoria c ON p.categoria_id = c.id WHERE p.nome = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getString("cat_nome"),
                        rs.getString("tamanho"),
                        rs.getString("embalagem")
                );
                categoria.setId(rs.getInt("cat_id"));

                Produto produto = new Produto(
                        rs.getString("nome"),
                        rs.getDouble("preco_unitario"),
                        rs.getString("unidade"),
                        rs.getInt("quantidade"),
                        rs.getInt("quantidade_minima"),
                        rs.getInt("quantidade_maxima"),
                        categoria
                );
                produto.setId(rs.getInt("id"));
                return produto;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        }

        return null;
    }

    public List<Produto> listarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.nome AS cat_nome, c.tamanho, c.embalagem, c.id AS cat_id " +
                     "FROM produto p JOIN categoria c ON p.categoria_id = c.id ORDER BY p.nome";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getString("cat_nome"),
                        rs.getString("tamanho"),
                        rs.getString("embalagem")
                );
                categoria.setId(rs.getInt("cat_id"));

                Produto produto = new Produto(
                        rs.getString("nome"),
                        rs.getDouble("preco_unitario"),
                        rs.getString("unidade"),
                        rs.getInt("quantidade"),
                        rs.getInt("quantidade_minima"),
                        rs.getInt("quantidade_maxima"),
                        categoria
                );
                produto.setId(rs.getInt("id"));

                lista.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }

        return lista;
    }

    public void atualizarQuantidade(String nomeProduto, int novaQuantidade) {
        String sql = "UPDATE produto SET quantidade = ? WHERE nome = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaQuantidade);
            stmt.setString(2, nomeProduto);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar quantidade: " + e.getMessage());
        }
    }

    public void reajustarPrecos(double percentual) {
        String sql = "UPDATE produto SET preco_unitario = preco_unitario * (1 + ? / 100)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, percentual);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao reajustar preços: " + e.getMessage());
        }
    }
}

    
}
>>>>>>> dc1c8f481c3e4939fb40e306aa774e09f2f799df
