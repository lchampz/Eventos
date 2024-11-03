package Classes;

import java.util.ArrayList;

public class Evento {
    private final int eventoId;
    private final int lotacaoMaxima;
    private double precoBase;
    private double precoVip;
    private final Organizador organizador;
    private final ArrayList<Ingresso> ingressosGerados;
    private Relatorio relatorio = new Relatorio(this);

    public double getPrecoVip() {
        return precoVip;
    }

    public void setPrecoVip(double precoVip) {
        this.precoVip = precoVip;
    }

    public Evento(int eventoId, int lotacaoMaxima, double preco_base, Organizador organizador) {
        this.eventoId = eventoId;
        this.lotacaoMaxima = lotacaoMaxima;
        this.precoBase = preco_base;
        this.precoVip = (preco_base * 0.5)  + preco_base;
        this.organizador = organizador;
        this.ingressosGerados = new ArrayList<>();
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public int geteventoId() {
        return eventoId;
    }

    public int getlotacaoMaxima() {
        return lotacaoMaxima;
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


    public Ingresso gerarIngresso(boolean is_vip) {
        try {
            if(lotacaoMaxima <= ingressosGerados.size()) throw new Exception("Evento Lotado!");
            Ingresso novoIngresso = new Ingresso(this, is_vip, is_vip ? (this.precoBase * 0.5) + this.precoBase : this.precoBase);
            ingressosGerados.add(novoIngresso);
            System.out.println("gerando novo ingresso...");
            return novoIngresso;
        } catch (Exception err) {
            System.out.println("[ERRO] " + err.getMessage());
            return null;
        }
    }
}
