package Classes;

import java.util.ArrayList;

public class Evento {
    private int eventoId;
    private int lotacaoMaxima;
    private double precoBase;
    private ArrayList<Ingresso> ingressosGerados;
    private Relatorio relatorio = new Relatorio(this);

    public Evento(int eventoId, int lotacaoMaxima, double preco_base) {
        this.eventoId = eventoId;
        this.lotacaoMaxima = lotacaoMaxima;
        this.precoBase = preco_base;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public int geteventoId() {
        return eventoId;
    }

    public void seteventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    public int getlotacaoMaxima() {
        return lotacaoMaxima;
    }

    public void setlotacaoMaxima(int lotacaoMaxima) {
        this.lotacaoMaxima = lotacaoMaxima;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public ArrayList<Ingresso> getIngressosGerados() {
        return ingressosGerados;
    }

    public void setIngressosGerados(ArrayList<Ingresso> ingressosGerados) {
        this.ingressosGerados = ingressosGerados;
    }

    public Ingresso gerarIngresso(boolean is_vip) {
        try {
            if(lotacaoMaxima >= ingressosGerados.size()) throw new Exception("Evento Lotado!");
            Ingresso novoIngresso = new Ingresso(this, is_vip, is_vip ? (this.precoBase * 0.5) + this.precoBase : this.precoBase);
            ingressosGerados.add(novoIngresso);
            return novoIngresso;
        } catch (Exception err) {
            System.out.println("[ERRO] " + err.getMessage());
            return null;
        }
    }
}
