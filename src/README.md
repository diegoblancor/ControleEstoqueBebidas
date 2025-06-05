# Projeto A3 - Controle de Estoque de Bebidas

Desenvolvido para a disciplina Programação de Soluções Computacionais – UNISUL

## Funcionalidades implementadas

- Cadastro de produtos e categorias
- Entrada e saída de estoque
- Reajuste de preços
- Relatórios gerenciais:
- Lista de preços
- Balanço físico-financeiro
- Produtos abaixo do mínimo
- Produtos acima do máximo
- Quantidade por categoria
- Interface gráfica (Swing) e opção por terminal

## Estrutura do Projeto

src/
├── controller/
│ └── EstoqueController.java
├── dao/
│ ├── CategoriaDAO.java
│ ├── Conexao.java
│ └── ProdutoDAO.java
├── model/
│ ├── Categoria.java
│ └── Produto.java
├── service/
│ └── RelatoriosService.java
└── view/
│ └── TelaPrincipal.java 
└── Main.java

## Execução

- Banco de dados: MySQL
- Conexão padrão: `root` sem senha no banco `controle_estoque`
- IDE sugerida: Visual Studio Code

## Repositório

[https://github.com/diegoblancor/ControleEstoqueBebidas.git]