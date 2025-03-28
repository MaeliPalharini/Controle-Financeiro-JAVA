package br.com.maeli.controlefinanceiro;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ControleFinanceiroApp {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Transacao> transacoes = new ArrayList<>();
        int opcao;

        do {
            System.out.println("==== CONTROLE FINANCEIRO ====");
            System.out.println("1. Adicionar despesa");
            System.out.println("2. Adicionar receita");
            System.out.println("3. Ver saldo atual");
            System.out.println("0. Sair");
            System.out.println("Digite uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); //Serve pra limpar quebra de linha

            switch (opcao) {
                case 1, 2 -> {
                    System.out.print("Descrição: ");
                    String descricao = entrada.nextLine();

                    System.out.print("Valor: ");
                    double valor = entrada.nextDouble();
                    entrada.nextLine();

                    String tipo = (opcao == 1) ? "despesa" : "receita";

                    Transacao nova = new Transacao(descricao, valor, tipo);
                    transacoes.add(nova);

                    System.out.println("Transação adiciconada!");
                }

                case 3 -> {
                    System.out.println("=== LISTA DE TRANSAÇÕES ===");

                    double saldo = 0;

                    for (Transacao t : transacoes){
                        System.out.println(t);

                        if(t.getTipo().equalsIgnoreCase("receita")){
                            saldo += t.getValor(); // Soma se for receita
                        } else if(t.getTipo().equalsIgnoreCase("despesa")){
                            saldo -=t.getValor(); // Subtrai se for despesa
                        }
                    }
                    System.out.println("----------------------------");
                    System.out.printf("Saldo atual: R$ %.2f%n", saldo);
                }
                case 0 -> System.out.println("Saindo...");
            }
            System.out.println();
        } while (opcao != 0);
    }
}
