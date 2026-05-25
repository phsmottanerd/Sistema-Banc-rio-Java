package Programa;

import Utilitarios.Utils;

public class Conta {

    private static int contador = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private double saldo;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contador++;
        this.pessoa = pessoa;
        this.saldo = 0.0;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "\nConta: " + numeroConta +
                "\nNome: " + pessoa.getNome() +
                "\nCPF: " + pessoa.getCpf() +
                "\nEmail: " + pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(saldo) +
                "\n";
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saque inválido!");
        }
    }

    public boolean transferir(Conta destino, double valor) {

        if (valor > 0 && saldo >= valor) {

            this.saldo -= valor;
            destino.saldo += valor;

            return true;
        }

        return false;
    }
}