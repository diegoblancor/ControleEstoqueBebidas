package model;

public class Produto {
 private int id;
 private String nome;
 private double precoUnitario;
 private String unidade;
 private int quantidade;
 private int quantidadeMinima;
 private int quantidadeMaxima;
 private Categoria categoria;

 public Produto(String nome, double precoUnitario, String unidade,
int quantidade, int quantidadeMinima, int quantidadeMaxima, Categoria categoria) {
 this.nome = nome;
 this.precoUnitario = precoUnitario;
 this.unidade = unidade;
 this.quantidade = quantidade;
 this.quantidadeMinima = quantidadeMinima;
 this.quantidadeMaxima = quantidadeMaxima;
 this.categoria = categoria;
 }

 // Getters e Setters
 public int getId() {
 return id;
 }

 public void setId(int id) {
 this.id = id;
 }

 public String getNome() {
 return nome;
 }

 public double getPrecoUnitario() {
 return precoUnitario;
 }

 public String getUnidade() {
 return unidade;
 }

 public int getQuantidade() {
 return quantidade;
 }

 public int getQuantidadeMinima() {
 return quantidadeMinima;
 }

 public int getQuantidadeMaxima() {
 return quantidadeMaxima;
 }

 public Categoria getCategoria() {
 return categoria;
 }

 public void setNome(String nome) {
 this.nome = nome;
 }

 public void setPrecoUnitario(double precoUnitario) {
 this.precoUnitario = precoUnitario;
 }

 public void setUnidade(String unidade) {
 this.unidade = unidade;
 }

 public void setQuantidade(int quantidade) {
 this.quantidade = quantidade;
 }

 public void setQuantidadeMinima(int quantidadeMinima) {
 this.quantidadeMinima = quantidadeMinima;
 }

 public void setQuantidadeMaxima(int quantidadeMaxima) {
 this.quantidadeMaxima = quantidadeMaxima;
 }

 public void setCategoria(Categoria categoria) {
 this.categoria = categoria;
 }

 // Métodos de movimentação de estoque
 public void entradaEstoque(int quantidadeAdicionada) {
 this.quantidade += quantidadeAdicionada;
 }

 public void saidaEstoque(int quantidadeRemovida) {
 this.quantidade -= quantidadeRemovida;
 }

 // Aliases para compatibilidade com nomes usados em outras classes
 public int getQtdMin() {
 return getQuantidadeMinima();
 }

 public int getQtdMax() {
 return getQuantidadeMaxima();
 }

 @Override
 public String toString() {
 return String.format("%s - %d %s - R$ %.2f - Categoria: %s",
 nome, quantidade, unidade, precoUnitario, categoria.getNome());
 }
}