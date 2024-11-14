package Interfaces;

import Classes.Evento;
import Classes.Ingresso;
import Classes.Participante;

public interface IPagamento {
    public void comprarIngresso(Participante participante, Evento evento, boolean vip);
}
