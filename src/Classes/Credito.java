package Classes;

import Interfaces.IPagamento;

public class Credito implements IPagamento {
    public double tax;

    public Credito(double tax) {
        this.tax = tax;
    }

    @Override
    public void comprarIngresso(Participante participante, Evento evento) {
        try {
            if(participante.isVip()) {
                if(participante.getSaldo() < evento.getPrecoVip()) throw new Exception("Saldo Insuficiente!");
            } else {
                if(participante.getSaldo() < evento.getPrecoBase()) throw new Exception("Saldo Insuficiente!");
            }
            System.out.println("Participante " + participante.getNome() + " comprou ingresso do tipo " + (participante.isVip() ? "VIP" : "normal") + " para o evento de id " + evento.geteventoId() + " compra feita no crédito");
            participante.setIngresso(evento.gerarIngresso(participante.isVip()));
            participante.setSaldo(participante.getSaldo() - (participante.getIngresso().getPreco() + (participante.getIngresso().getPreco() * tax)));
        } catch (Exception err) {
            System.out.println("[ERRO] "+ err.getMessage());
        }
    }
}
