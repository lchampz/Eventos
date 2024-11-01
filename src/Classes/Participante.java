package Classes;

import Interfaces.IPessoa;

public class Participante extends IPessoa {
    private boolean isVip;

    public Participante(String nome, TIPO tipoPessoa) {
        super(nome, tipoPessoa);
    }


}
