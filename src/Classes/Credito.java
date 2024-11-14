package Classes;

import Interfaces.IPagamento;

public class Credito implements IPagamento {
    public double tax;

    public Credito(double tax) {
        this.tax = tax;
    }

    @Override
    public void comprarIngresso(Participante participante, Evento evento, boolean vip) {
        try {
            if(vip) {
                if(participante.getSaldo() < evento.getPrecoVip()) throw new Exception("Saldo Insuficiente!");
            } else {
                if(participante.getSaldo() < evento.getPrecoBase()) throw new Exception("Saldo Insuficiente!");
            }
            System.out.println("Participante " + participante.getNome() + " comprou ingresso do tipo " + (vip ? "VIP" : "normal") + " para o evento " + evento.getNome() + " compra feita no crédito");
            participante.setIngresso(evento.gerarIngresso(vip));
            participante.setSaldo(participante.getSaldo() - (participante.getIngresso().getPreco() + (participante.getIngresso().getPreco() * tax)));
        } catch (Exception err) {
            System.out.println("[ERRO] "+ err.getMessage());
        }
    }
}
