package Classes;

import java.util.concurrent.atomic.AtomicInteger;

public class Relatorio {
    public Evento evento;

    public Relatorio(Evento evento) {
        this.evento = evento;
    }

    public void lucroTotal() {
        double lucro = evento.getIngressosGerados().stream().map(Ingresso::getPreco).reduce(0.0, Double::sum);
        String texto = "O evento de id " + evento.geteventoId() + " gerou o lucro de R$ " + lucro + " com a venda de " + evento.getIngressosGerados().size() + " ingressos";
        System.out.println(texto);
    }

    public void tiposIngresso() {
        AtomicInteger vip = new AtomicInteger(0);
        AtomicInteger notVip = new AtomicInteger(0);

        double precoVip = (evento.getPrecoBase() * 0.5) + evento.getPrecoBase();

        evento.getIngressosGerados().forEach(ingresso -> {
            if(ingresso.isVip()) vip.getAndIncrement();
            else notVip.getAndIncrement();
        });

        String texto = "O evento de id " + evento.geteventoId() + " teve " + vip + " ingressos vip (R$ " + precoVip * vip.get() + ") e " + notVip + " normais (R$ " + evento.getPrecoBase() * notVip.get() + ")" ;

        System.out.println(texto);
    }
}
