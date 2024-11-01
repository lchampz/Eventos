package Classes;

import java.util.UUID;

public class Ingresso {
    private UUID codigo;
    private boolean isVip;
    private Evento evento;
    private double preco;

    public Ingresso(Evento evento, boolean isVip, double preco) {
        this.evento = evento;
        this.codigo = UUID.randomUUID();
        this.isVip = isVip;
        this.preco = preco;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public boolean isVip() {
        return isVip;
    }

    public Evento getEvento() {
        return evento;
    }

    public double getPreco() {
        return preco;
    }
}
