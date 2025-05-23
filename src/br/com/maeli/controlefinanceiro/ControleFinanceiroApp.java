package br.com.maeli.controlefinanceiro;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ControleFinanceiroApp {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Transacao> transacoes = new ArrayList<>();
        int opcao;

        List<Categoria> categorias = List.of(
                new Categoria("Alimentação"),
                new Categoria("Transporte"),
                new Categoria("Lazer"),
                new Categoria("Educação"),
                new Categoria("Saúde"),
                new Categoria("Pets"),
                new Categoria("Outros")
        );

        do {
            System.out.println("==== CONTROLE FINANCEIRO ====");
            System.out.println("1. Adicionar despesa");
            System.out.println("2. Adicionar receita");
            System.out.println("3. Ver saldo atual");
            System.out.println("4. Ver transações por categoria");
            System.out.println("5. Remover transação");
            System.out.println("0. Sair");
            System.out.println("Digite uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcao) {
                case 1, 2 -> {
                    System.out.print("Descrição: ");
                    String descricao = entrada.nextLine();

                    System.out.print("Valor: ");
                    double valor = entrada.nextDouble();
                    entrada.nextLine();

                    System.out.print("Escolha uma categoria:");
                    for (int i=0; i < categorias.size(); i++) {
                        System.out.println((i+1) + ". " + categorias.get(i).getNome());
                    }

                    int catIndex = entrada.nextInt();
                    entrada.nextLine();
                    Categoria categoria = categorias.get(catIndex - 1);

                    String tipo = (opcao == 1) ? "despesa" : "receita";

                    Transacao nova = new Transacao(descricao, valor, tipo, categoria);
                    transacoes.add(nova);

                    System.out.println("Transação adicionada!");
                }

                case 3 -> {
                    System.out.println("=== LISTA DE TRANSAÇÕES ===");

                    double saldo = 0;

                    for (Transacao t : transacoes){
                        System.out.println(t);

                        if(t.getTipo().equalsIgnoreCase("receita")){
                            saldo += t.getValor();
                        } else if(t.getTipo().equalsIgnoreCase("despesa")){
                            saldo -=t.getValor();
                        }
                    }
                    System.out.println("----------------------------");
                    System.out.printf("Saldo atual: R$ %.2f%n", saldo);
                }

                case 4 -> {
                    System.out.println("Escolha a categoria para filtrar:");

                    for (int i = 0; i < categorias.size(); i++) {
                        System.out.println((i + 1) + ". " + categorias.get(i).getNome());
                    }

                    int catIndex = entrada.nextInt();
                    entrada.nextLine(); 
                    Categoria categoriaSelecionada = categorias.get(catIndex - 1);

                    System.out.println("=== Transações da categoria: " + categoriaSelecionada.getNome() + " ===");

                    boolean encontrou = false;

                    for (Transacao t : transacoes) {
                        if (t.getCategoria().getNome().equalsIgnoreCase(categoriaSelecionada.getNome())) {
                            System.out.println(t);
                            encontrou = true;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Nenhuma transação encontrada para essa categoria.");
                    }
                }

                case 5 -> {
                    if (transacoes.isEmpty()) {
                        System.out.println("Nenhuma transação para remover");
                        break;
                    }

                    System.out.println("=== Transações cadastradas ===");
                    for (int i = 0; i < transacoes.size(); i++) {
                        System.out.println((i+1) + ". " + transacoes.get(i));
                    }

                    System.out.print("Digite o número da transação que deseja remover");
                    int indice = entrada.nextInt();
                    entrada.nextLine();

                    if(indice >= 1 && indice <= transacoes.size()) {
                        Transacao removida = transacoes.remove(indice - 1);
                        System.out.println("Transação removida: " + removida);
                    } else {
                        System.out.println("Índice inválido!");
                    }
                }

                case 0 -> System.out.println("Saindo...");

            }

            System.out.println();

        } while (opcao != 0);
    }
}
