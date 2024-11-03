import Classes.*;
import Interfaces.IPessoa;

public class Main {
    public static void main(String[] args) {
        Debito debito = new Debito();
        Credito credito = new Credito(0.1);

        Organizador organizador = new Organizador("Cleiton");
        Participante participante = new Participante(true, "Victor", 3000);

        Evento evento = organizador.criarEvento(1, 200, 100);

        debito.comprarIngresso(participante, evento);

        evento.getRelatorio().tiposIngresso();
        evento.getRelatorio().lucroTotal();

    }
}