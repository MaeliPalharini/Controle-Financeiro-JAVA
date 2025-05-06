package br.com.maeli.controlefinanceiro;

public class Transacao {
    private String descricao; //Métodos String e double
    private double valor;
    private String tipo; // Se receita ou despesa
    private Categoria categoria; // Ex: Alimentação, Transporte, Lazer

    //Construtor
    public Transacao(String descricao, double valor, String tipo, Categoria categoria){
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public String getDescricao(){
        return descricao;
    }

    public double getValor(){
        return valor;
    }

    public String getTipo(){
        return tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    //
    @Override
    public String toString() {
        return tipo.toUpperCase() + ": " + descricao + " - R$ " + valor + " | Categoria: " + categoria.getNome();
    }
}
