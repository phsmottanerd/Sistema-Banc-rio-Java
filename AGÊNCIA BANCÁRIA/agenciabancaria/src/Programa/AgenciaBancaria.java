package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias = new ArrayList<>();

    public static void main(String[] args) {
        operacoes();
    }

    private static void operacoes() {

        while (true) {

            System.out.println("\n--------------------------------------------------");
            System.out.println("------------ Bem-vindo à Agência -----------------");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Listar contas");
            System.out.println("6 - Sair");

            int operacao = input.nextInt();
            input.nextLine();

            switch (operacao) {

                case 1 -> criarConta();
                case 2 -> depositar();
                case 3 -> sacar();
                case 4 -> transferir();
                case 5 -> listarContas();
                case 6 -> {
                    System.out.println("Obrigado por usar nossa agência!");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    public static void criarConta() {

        System.out.println("Nome:");
        String nome = input.nextLine();

        System.out.println("CPF:");
        String cpf = input.nextLine();

        System.out.println("Email:");
        String email = input.nextLine();

        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);

        System.out.println("Conta criada com sucesso! Número: " + conta.getNumeroConta());
    }

    private static Conta encontrarConta(int numeroConta) {

        for (Conta c : contasBancarias) {
            if (c.getNumeroConta() == numeroConta) {
                return c;
            }
        }
        return null;
    }

    public static void depositar() {

        System.out.println("Número da conta:");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {

            System.out.println("Valor do depósito:");
            double valor = input.nextDouble();

            conta.depositar(valor);

        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public static void sacar() {

        System.out.println("Número da conta:");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {

            System.out.println("Valor do saque:");
            double valor = input.nextDouble();

            conta.sacar(valor);

        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public static void transferir() {

        System.out.println("Conta remetente:");
        int remetente = input.nextInt();

        Conta contaRemetente = encontrarConta(remetente);

        if (contaRemetente != null) {

            System.out.println("Conta destino:");
            int destino = input.nextInt();

            Conta contaDestino = encontrarConta(destino);

            if (contaDestino != null) {

                System.out.println("Valor da transferência:");
                double valor = input.nextDouble();

                boolean sucesso = contaRemetente.transferir(contaDestino, valor);

                if (sucesso) {
                    System.out.println("Transferência realizada com sucesso!");
                } else {
                    System.out.println("Transferência inválida!");
                }

            } else {
                System.out.println("Conta destino não encontrada!");
            }

        } else {
            System.out.println("Conta remetente não encontrada!");
        }
    }

    public static void listarContas() {

        if (contasBancarias.isEmpty()) {
            System.out.println("Não há contas cadastradas!");
            return;
        }

        for (Conta conta : contasBancarias) {
            System.out.println(conta);
        }
    }
}