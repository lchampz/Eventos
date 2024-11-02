package Classes;

import Interfaces.IPessoa;

public class Participante extends IPessoa {
    private boolean isVip;
    private Ingresso ingresso;
    private double saldo;

    public Participante(boolean isVip, String nome, double saldo) {
        super(nome, TIPO.PARTICIPANTE);
        this.saldo = saldo;
        this.isVip = isVip;
    }

    public boolean isVip() {
        return isVip;
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
