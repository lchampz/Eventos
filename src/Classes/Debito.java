package Classes;

import Interfaces.IPagamento;

public class Debito implements IPagamento {

    @Override
    public void comprarIngresso(Participante participante, Evento evento) {
        try {
            if(participante.isVip()) {
                if(participante.getSaldo() < evento.getPrecoVip()) throw new Exception("Saldo Insuficiente!");
            } else {
                if(participante.getSaldo() < evento.getPrecoBase()) throw new Exception("Saldo Insuficiente!");
            }
            participante.setIngresso(evento.gerarIngresso(participante.isVip()));
            participante.setSaldo(participante.getSaldo() - participante.getIngresso().getPreco());
        } catch (Exception err) {
            System.out.println("[ERRO] "+ err.getMessage());
        }
    }
}
