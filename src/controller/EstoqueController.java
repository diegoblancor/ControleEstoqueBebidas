package controller;

import dao.ProdutoDAO;
import model.Produto;

import java.util.List;

public class EstoqueController {
 private final ProdutoDAO produtoDAO;

 public EstoqueController() {
 this.produtoDAO = new ProdutoDAO();
 }

public void adicionarProduto(Produto p) {
 produtoDAO.inserir(p);
 }

public Produto buscarProduto(String nome) {
 return produtoDAO.buscarPorNome(nome);
 }

 public boolean removerProduto(String nome) {
 // Este método só estará funcional se houver implementação em ProdutoDAO
 // return produtoDAO.remover(nome);
 reurn false; // Placeholder se ainda não implementado
 }

 public void reajustarPrecos(double percentual) {
 produtoDAO.reajustarPrecos(percentual);
 }

 public List<Produto> listarProdutosOrdenados() {
 return produtoDAO.listarTodos();
 }

 public void entradaEstoque(String nomeProduto, int quantidade) {
 Produto p = produtoDAO.buscarPorNome(nomeProduto);
 if (p != null) {
 p.entradaEstoque(quantidade);
 produtoDAO.atualizarQuantidade(nomeProduto, p.getQuantidade());
  if (p.getQuantidade() > p.getQtdMax()) {
 System.out.println("Estoque acima do máximo para o produto: " + p.getNome());
 }
 }
 }

 public void saidaEstoque(String nomeProduto, int quantidade) {
 Produto p = produtoDAO.buscarPorNome(nomeProduto);
 if (p != null) {
 if (p.getQuantidade() >= quantidade) {
 p.saidaEstoque(quantidade);
 produtoDAO.atualizarQuantidade(nomeProduto, p.getQuantidade());
 if (p.getQuantidade() < p.getQtdMin()) {
 System.out.println("Estoque abaixo do mínimo para o produto: " + p.getNome());
 }
 } else {
 System.out.println("Estoque insuficiente para retirada.");
 }
 }
 }

public List<Produto> getProdutos() {
 return produtoDAO.listarTodos();
 }
}