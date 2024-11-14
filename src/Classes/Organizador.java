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

    public Evento criarEvento(int lotacaoMaxima, double preco_base, String nome) {
        Evento novoEvento = new Evento( lotacaoMaxima, preco_base, this, nome);

        eventos.add(novoEvento);

        System.out.println("Evento de nome " + novoEvento.getNome() + " cadastrado pelo organizador " + this.getNome() + " criado com sucesso!");

        return novoEvento;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }
}
