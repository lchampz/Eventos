package Classes;

import Interfaces.IPessoa;

import java.util.ArrayList;

public class Organizador extends IPessoa {
    public ArrayList<Evento> eventos;

    public Organizador(String nome) {
        super(nome, TIPO.ORGANIZADOR);
        this.eventos = new ArrayList<>();
        System.out.println("Organizador " + nome + " criado");
    }

    public Evento criarEvento(int eventoId, int lotacaoMaxima, double preco_base) {
        Evento novoEvento = new Evento(eventoId, lotacaoMaxima, preco_base, this);

        eventos.add(novoEvento);

        System.out.println("Evento de id " + eventoId + " cadastrado pelo organizador " + this.getNome() + " criado com sucesso!");

        return novoEvento;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }
}
