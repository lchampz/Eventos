package Interfaces;

public abstract class IPessoa {
    public enum TIPO {
        PARTICIPANTE, ORGANIZADOR
    }
    private String nome;
    private TIPO tipoPessoa;

    public IPessoa(String nome, TIPO tipoPessoa) {
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TIPO getTipoPessoa() {
        return tipoPessoa;
    }

    @Override
    public String toString() {
        return "O " + nome + " é " + tipoPessoa;
    }
}
