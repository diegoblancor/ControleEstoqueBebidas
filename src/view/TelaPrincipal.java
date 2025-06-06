package view;

import controller.EstoqueController;
import model.Categoria;
import model.Produto;
import service.RelatoriosService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaPrincipal extends JFrame {
private final EstoqueController estoque;
private final JTextArea areaTexto;

public TelaPrincipal(EstoqueController estoque) {
this.estoque = estoque;

setTitle("Controle de Estoque - Loja de Bebidas");
setSize(800, 600);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());

// Painel de botões
JPanel painelBotoes = new JPanel(new GridLayout(0, 1));
JButton btnCadastrar = new JButton("Cadastrar Produto");
JButton btnListar = new JButton("Listar Produtos");
JButton btnEntrada = new JButton("Entrada de Estoque");
JButton btnSaida = new JButton("Saída de Estoque");
JButton btnReajuste = new JButton("Reajustar Preços");
JButton btnRelatorios = new JButton("Relatórios");
JButton btnSair = new JButton("Sair");

painelBotoes.add(btnCadastrar);
painelBotoes.add(btnListar);
painelBotoes.add(btnEntrada);
painelBotoes.add(btnSaida);
painelBotoes.add(btnReajuste);
painelBotoes.add(btnRelatorios);
painelBotoes.add(btnSair);

add(painelBotoes, BorderLayout.WEST);

// Área de exibição
areaTexto = new JTextArea();
areaTexto.setEditable(false);
add(new JScrollPane(areaTexto), BorderLayout.CENTER);

// Ações
btnCadastrar.addActionListener(e -> cadastrarProduto());
btnListar.addActionListener(e -> listarProdutos());
btnEntrada.addActionListener(e -> entradaEstoque());
btnSaida.addActionListener(e -> saidaEstoque());
btnReajuste.addActionListener(e -> reajustarPrecos());
btnRelatorios.addActionListener(e -> gerarRelatorios());
btnSair.addActionListener(e -> {
JOptionPane.showMessageDialog(this, "Saindo do sistema...");
System.exit(0);
});
}

private void cadastrarProduto() {
try {
String nome = JOptionPane.showInputDialog(this, "Nome do produto:");
double preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Preço unitário:"));
String[] unidades = {"unidade", "litro", "garrafa", "caixa", "barril"};
String unidade = (String) JOptionPane.showInputDialog(this, "Unidade:", "Unidade",
JOptionPane.QUESTION_MESSAGE, null, unidades, unidades[0]);
int qtd = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantidade em estoque:"));
int qtdMin = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantidade mínima:"));
int qtdMax = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantidade máxima:"));
String catNome = JOptionPane.showInputDialog(this, "Nome da categoria:");
String catTam = JOptionPane.showInputDialog(this, "Tamanho da categoria:");
String catEmb = JOptionPane.showInputDialog(this, "Embalagem da categoria:");

Categoria categoria = new Categoria(catNome, catTam, catEmb);
Produto p = new Produto(nome, preco, unidade, qtd, qtdMin, qtdMax, categoria);
estoque.adicionarProduto(p);
areaTexto.setText("Produto cadastrado com sucesso!");
} catch (Exception ex) {
areaTexto.setText("Erro ao cadastrar produto: " + ex.getMessage());
}
}

private void listarProdutos() {
StringBuilder sb = new StringBuilder("Produtos em estoque:\n");
for (Produto p : estoque.listarProdutosOrdenados()) {
sb.append(String.format("- %s | Preço: R$ %.2f | Qtd: %d %s | Cat: %s\n",
p.getNome(), p.getPrecoUnitario(), p.getQuantidade(),
p.getUnidade(), p.getCategoria().getNome()));
}
areaTexto.setText(sb.toString());
}

private void entradaEstoque() {
String nome = JOptionPane.showInputDialog(this, "Nome do produto (entrada):");
int qtd = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantidade de entrada:"));
estoque.entradaEstoque(nome, qtd);
areaTexto.setText("Entrada realizada!");
}

private void saidaEstoque() {
String nome = JOptionPane.showInputDialog(this, "Nome do produto (saída):");
int qtd = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantidade de saída:"));
estoque.saidaEstoque(nome, qtd);
areaTexto.setText("Saída realizada!");
}

private void reajustarPrecos() {
double perc = Double.parseDouble(JOptionPane.showInputDialog(this, "Percentual de reajuste:"));
estoque.reajustarPrecos(perc);
areaTexto.setText("Preços reajustados!");
}

private void gerarRelatorios() {
RelatoriosService r = new RelatoriosService();
List<Produto> produtos = estoque.getProdutos();
StringBuilder sb = new StringBuilder();
sb.append("RELATÓRIOS\n\n");
sb.append("Lista de Preços:\n");
r.listaDePrecos(produtos, sb);
sb.append("\nBalanço Físico/Financeiro:\n");
r.balancoFisicoFinanceiro(produtos, sb);
sb.append("\nProdutos abaixo do mínimo:\n");
r.produtosAbaixoMinimo(produtos, sb);
sb.append("\nProdutos acima do máximo:\n");
r.produtosAcimaMaximo(produtos, sb);
sb.append("\nQuantidade por categoria:\n");
r.quantidadePorCategoria(produtos, sb);
areaTexto.setText(sb.toString());
}
}