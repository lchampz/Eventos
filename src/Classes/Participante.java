package Classes;

import Interfaces.IPessoa;

public class Participante extends IPessoa {
    private Ingresso ingresso;
    private double saldo;

    public Participante(String nome, double saldo) {
        super(nome, TIPO.PARTICIPANTE);
        this.saldo = saldo;


        System.out.println("Participante " + nome + " criado");
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
