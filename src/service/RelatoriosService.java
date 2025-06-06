package service; 

 

import model.Produto; 

 

import java.util.HashMap; 

import java.util.List; 

import java.util.Map; 

 

public class RelatoriosService { 

 

 public void listaDePrecos(List<Produto> produtos, StringBuilder sb) { 

 produtos.stream() 

 .sorted((p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome())) 

 .forEach(p -> sb.append(String.format("- %s | Preço: R$ %.2f | Unidade: %s | Categoria: %s\n", 

 p.getNome(), p.getPrecoUnitario(), p.getUnidade(), p.getCategoria().getNome()))); 

 } 

 

 public void balancoFisicoFinanceiro(List<Produto> produtos, StringBuilder sb) { 

 double totalEstoque = 0.0; 

 

 for (Produto p : produtos) { 

 double total = p.getPrecoUnitario() * p.getQuantidade(); 

 totalEstoque += total; 

 sb.append(String.format("- %s | Qtd: %d %s | Total: R$ %.2f\n", 

 p.getNome(), p.getQuantidade(), p.getUnidade(), total)); 

 } 

 

 sb.append(String.format("\nValor total do estoque: R$ %.2f\n", totalEstoque)); 

 } 

 

 public void produtosAbaixoMinimo(List<Produto> produtos, StringBuilder sb) { 

 produtos.stream() 

 .filter(p -> p.getQuantidade() < p.getQuantidadeMinima()) 

 .forEach(p -> sb.append(String.format("- %s | Estoque: %d | Mínimo: %d\n", 

 p.getNome(), p.getQuantidade(), p.getQuantidadeMinima()))); 

 } 

 

public void produtosAcimaMaximo(List<Produto> produtos, StringBuilder sb) { 

produtos.stream() 

 .filter(p -> p.getQuantidade() > p.getQuantidadeMaxima()) 

 .forEach(p -> sb.append(String.format("- %s | Estoque: %d | Máximo: %d\n", 

 p.getNome(), p.getQuantidade(), p.getQuantidadeMaxima()))); 

 } 

 

public void quantidadePorCategoria(List<Produto> produtos, StringBuilder sb) { 

 Map<String, Integer> mapa = new HashMap<>(); 

 

 for (Produto p : produtos) { 

 String cat = p.getCategoria().getNome(); 

 mapa.put(cat, mapa.getOrDefault(cat, 0) + 1); 

 } 

 

 mapa.forEach((categoria, quantidade) -> 

 sb.append(String.format("- %s: %d produto(s)\n", categoria, quantidade))); 

 } 

 

 // Métodos para uso no terminal 

 public void listaDePrecos(List<Produto> produtos) { 

 StringBuilder sb = new StringBuilder(); 

 listaDePrecos(produtos, sb); 

 System.out.println(sb.toString()); 

 } 

 

 public void balancoFisicoFinanceiro(List<Produto> produtos) { 

 StringBuilder sb = new StringBuilder(); 

 balancoFisicoFinanceiro(produtos, sb); 

 System.out.println(sb.toString()); 

 } 

 
 public void produtosAbaixoMinimo(List<Produto> produtos) { 

 StringBuilder sb = new StringBuilder(); 

 produtosAbaixoMinimo(produtos, sb); 

 System.out.println(sb.toString()); 

 } 

 

 public void produtosAcimaMaximo(List<Produto> produtos) { 

 StringBuilder sb = new StringBuilder(); 

 produtosAcimaMaximo(produtos, sb); 

 System.out.println(sb.toString()); 

 } 

 

 public void quantidadePorCategoria(List<Produto> produtos) { 

 StringBuilder sb = new StringBuilder(); 

 quantidadePorCategoria(produtos, sb); 

 System.out.println(sb.toString()); 

 } 

} 
