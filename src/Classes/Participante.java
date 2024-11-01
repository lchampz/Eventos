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

    public void comprarIngresso(Evento evento) {
        try {
            if(saldo < evento.getPrecoVip()) throw new Exception("Saldo Insuficiente!");
            this.ingresso = evento.gerarIngresso(isVip);
            this.saldo -= this.ingresso.getPreco();
        } catch (Exception err) {
            System.out.println("[ERRO] "+ err.getMessage());
        }
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public boolean isVip() {
        return isVip;
    }

    public double getSaldo() {
        return saldo;
    }
}
