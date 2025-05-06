package br.com.maeli.controlefinanceiro;

public class Categoria {
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString(){
        return nome;
    }
}
