package br.com.maeli.controlefinanceiro;

public class Transacao {
    private String descricao; //Métodos String e double
    private double valor;
    private String tipo; // Se receita ou despesa

    //Construtor
    public Transacao(String descricao, double valor, String tipo){
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
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
    //
    @Override
    public String toString() {
        return tipo.toUpperCase() + ": " + descricao + " - R$ " + valor;
    }
}
