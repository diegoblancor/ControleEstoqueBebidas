package model; 

 

public class Categoria { 

<<<<<<< HEAD
 private int id; 

 private String nome; 

 private String tamanho;   // Pequeno, Médio, Grande 

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
=======
<<<<<<< HEAD
public class Categoria {
private int id;
private String nome;
private String tamanho; // Pequeno, Médio, Grande
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
=======
}
>>>>>>> dc1c8f481c3e4939fb40e306aa774e09f2f799df
>>>>>>> e3577363e7589602cdb66965db8c6c4bfe597bb2
