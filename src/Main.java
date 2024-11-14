import Classes.*;
import Interfaces.IPessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Debito debito = new Debito();
        Credito credito = new Credito(0.1);

        ArrayList<Participante> participantes = new ArrayList<>();
        ArrayList<Evento> eventos = new ArrayList<>();
        ArrayList<Organizador> organizadores = new ArrayList<>();

        boolean loop = true;

        while (loop) {
            int menuOption = menu();
            switch (menuOption) {
                case 1:
                    organizadores.add(criarOrganizador());
                    break;
                case 2:
                    participantes.add(criarParticipante());
                    break;
                case 3:
                    eventos.add(criarEvento(organizadores));
                    break;
                case 4:
                    comprarIngresso(participantes, eventos, debito, credito);
                    break;
                case 5:
                    gerarRelatorios(eventos);
                    break;
                case 0:
                    loop = false;
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static int menu() {
        System.out.println("\n----- MENU -----");
        System.out.println("1 - Cadastrar Organizador");
        System.out.println("2 - Cadastrar Participante");
        System.out.println("3 - Cadastrar Evento");
        System.out.println("4 - Comprar Ingresso");
        System.out.println("5 - Relatório do Evento");
        System.out.println("0 - Encerrar");
        System.out.print("\nEscolha uma opção: ");
        return scanner.nextInt();
    }

    public static Organizador criarOrganizador() {
        System.out.print("\nDigite o nome do organizador: ");
        String nome = scanner.next();
        System.out.println(" ");
        return new Organizador(nome);
    }

    public static Participante criarParticipante() {
        System.out.print("Digite o nome do participante: ");
        String nome = scanner.next();

        System.out.print("Digite o saldo na conta: ");
        double saldo = scanner.nextDouble();


        System.out.println(" ");
        return new Participante(nome, saldo);
    }

    public static Evento criarEvento(ArrayList<Organizador> organizadores) {
        if (organizadores.isEmpty()) {
            System.out.println("Nenhum organizador disponível. Cadastre um antes de criar um evento.");
            return null;
        }

        System.out.println("Selecione o organizador desejado (pelo número):");
        for (int i = 0; i < organizadores.size(); i++) {
            System.out.println(i + " - " + organizadores.get(i).getNome());
        }
        System.out.print("R: ");
        int escolha = scanner.nextInt();

        System.out.print("Digite o preço base do evento: ");
        double preco = scanner.nextDouble();

        System.out.print("Digite a capacidade máxima de pessoas no evento: ");
        int capacidade = scanner.nextInt();

        System.out.print("Digite o nome do evento: ");
        String nome = scanner.next();
        System.out.println(" ");
        return organizadores.get(escolha).criarEvento(capacidade, preco, nome);
    }

    public static void comprarIngresso(ArrayList<Participante> participantes, ArrayList<Evento> eventos, Debito debito, Credito credito) {
        if (participantes.isEmpty() || eventos.isEmpty()) {
            System.out.println("Não há participantes ou eventos disponíveis para compra de ingressos.");
            return;
        }

        System.out.println("Selecione um participante (pelo número):");
        for (int i = 0; i < participantes.size(); i++) {
            System.out.println(i + " - " + participantes.get(i).getNome() + " (Saldo: " + participantes.get(i).getSaldo() + ")");
        }
        System.out.print("R: ");
        int participanteIndex = scanner.nextInt();

        System.out.println("Selecione um evento (pelo número):");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println(i + " - " + eventos.get(i).getNome());
        }
        System.out.print("R: ");
        int eventoIndex = scanner.nextInt();

        System.out.print("Escolha o método de pagamento (1 - Débito, 2 - Crédito): ");
        int metodoPagamento = scanner.nextInt();

        System.out.print("VIP (R$ " + eventos.get(eventoIndex).getPrecoVip() +  ")? (1 - Sim, 2 - Não): ");
        int vip = scanner.nextInt();

        if (metodoPagamento == 1) {
            debito.comprarIngresso(participantes.get(participanteIndex), eventos.get(eventoIndex), vip == 1 ? true : false);
        } else if (metodoPagamento == 2) {
            credito.comprarIngresso(participantes.get(participanteIndex), eventos.get(eventoIndex), vip == 1 ? true : false);
        } else {
            System.out.println("Método de pagamento inválido.");
        }

    }

    public static void gerarRelatorios(ArrayList<Evento> eventos) {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado para gerar relatórios.");
            return;
        }

        for (Evento evento : eventos) {
            System.out.println("\nRelatório do Evento: " + evento.getNome());
            evento.getRelatorio().tiposIngresso();
            evento.getRelatorio().lucroTotal();
        }
    }
}
