import controller.EstoqueController;
import model.Categoria;
import model.Produto;
import service.RelatoriosService;
import view.TelaPrincipal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EstoqueController estoque = new EstoqueController();

        System.out.println("Escolha o modo de uso:");
        System.out.println("1 - Terminal");
        System.out.println("2 - Interface Gráfica");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();
        sc.nextLine(); // consumir quebra de linha

        if (opcao == 1) {
            iniciarTerminal(estoque, sc);
        } else if (opcao == 2) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                new TelaPrincipal(estoque).setVisible(true);
            });
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void iniciarTerminal(EstoqueController estoque, Scanner sc) {
        RelatoriosService relatorios = new RelatoriosService();
        int opcao;

        do {
            System.out.println("\n=== MENU - CONTROLE DE ESTOQUE ===");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Entrada de estoque");
            System.out.println("4. Saída de estoque");
            System.out.println("5. Reajustar preços");
            System.out.println("6. Relatório - Lista de Preços");
            System.out.println("7. Relatório - Balanço Físico/Financeiro");
            System.out.println("8. Relatório - Abaixo do mínimo");
            System.out.println("9. Relatório - Acima do máximo");
            System.out.println("10. Relatório - Qtde por categoria");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            while (!sc.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                sc.next(); // descarta entrada inválida
            }

            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra

            switch (opcao) {
                case 1 -> {
                    try {
                        System.out.print("Nome do produto: ");
                        String nome = sc.nextLine();

                        System.out.print("Preço unitário (ex: 3,50 ou 3.50): ");
                        double preco = Double.parseDouble(sc.nextLine().replace(",", "."));

                        System.out.print("Unidade: ");
                        String unidade = sc.nextLine();

                        System.out.print("Quantidade atual: ");
                        int qtd = Integer.parseInt(sc.nextLine());

                        System.out.print("Qtd mínima: ");
                        int qtdMin = Integer.parseInt(sc.nextLine());

                        System.out.print("Qtd máxima: ");
                        int qtdMax = Integer.parseInt(sc.nextLine());

                        System.out.print("Categoria: ");
                        String catNome = sc.nextLine();

                        System.out.print("Tamanho: ");
                        String tamanho = sc.nextLine();

                        System.out.print("Embalagem: ");
                        String embalagem = sc.nextLine();

                        Produto p = new Produto(nome, preco, unidade, qtd, qtdMin, qtdMax,
                                new Categoria(catNome, tamanho, embalagem));
                        estoque.adicionarProduto(p);
                        System.out.println("Produto cadastrado!");
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar: " + e.getMessage());
                    }
                }
                case 2 -> {
                    for (Produto prod : estoque.listarProdutosOrdenados()) {
                        System.out.printf("- %s | Preço: R$ %.2f | Estoque: %d %s | Categoria: %s\n",
                                prod.getNome(), prod.getPrecoUnitario(), prod.getQuantidade(),
                                prod.getUnidade(), prod.getCategoria().getNome());
                    }
                }
                case 3 -> {
                    System.out.print("Produto (entrada): ");
                    String nomeEntrada = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtdEntrada = sc.nextInt();
                    sc.nextLine();
                    estoque.entradaEstoque(nomeEntrada, qtdEntrada);
                }
                case 4 -> {
                    System.out.print("Produto (saída): ");
                    String nomeSaida = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtdSaida = sc.nextInt();
                    sc.nextLine();
                    estoque.saidaEstoque(nomeSaida, qtdSaida);
                }
                case 5 -> {
                    System.out.print("Percentual de reajuste (ex: 10,5): ");
                    double percentual = Double.parseDouble(sc.nextLine().replace(",", "."));
                    estoque.reajustarPrecos(percentual);
                    System.out.println("Preços reajustados!");
                }
                case 6 -> relatorios.listaDePrecos(estoque.getProdutos());
                case 7 -> relatorios.balancoFisicoFinanceiro(estoque.getProdutos());
                case 8 -> relatorios.produtosAbaixoMinimo(estoque.getProdutos());
                case 9 -> relatorios.produtosAcimaMaximo(estoque.getProdutos());
                case 10 -> relatorios.quantidadePorCategoria(estoque.getProdutos());
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}