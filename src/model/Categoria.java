package model;

public class Categoria {
    private int id;
    private String nome;
    private String tamanho;   // Pequeno, Médio, Grande
    private String embalagem; // Lata, Vidro, Plástico

    public Categoria(String nome, String tamanho, String embalagem) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
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

    public String getTamanho() {
        return tamanho;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    @Override
    public String toString() {
        return nome + " (" + tamanho + ", " + embalagem + ")";
    }
}