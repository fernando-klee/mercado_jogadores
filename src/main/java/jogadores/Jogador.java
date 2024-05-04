package jogadores;

import static jogadores.Conservador.PERCENTUAL_CONSERVADOR;
import static jogadores.Mercenario.PERCENTUAL_MERCENARIO;

public abstract class Jogador {
    private String nome;
    private int idade;
    private String clubeAtual;
    private int reputacaoJogador;
    private Apetite apetiteFinanceiro;
    private double preco;

    public Jogador(String nome, int idade, String clubeAtual, int reputacaoJogador, Apetite apetiteFinanceiro, double preco) {
        this.nome = nome;
        this.idade = idade;
        this.clubeAtual = clubeAtual;
        if (reputacaoJogador < 0 || reputacaoJogador > 10){throw new IllegalArgumentException();
        } else {
            this.reputacaoJogador = reputacaoJogador;
        }
        this.apetiteFinanceiro = apetiteFinanceiro;
        this.preco = preco;
    }

    public int getIdade() {return idade;}

    public String getClubeAtual() {
        if(this.clubeAtual == null){return  "Sem Clube";} return this.clubeAtual;
    }

    public void setClubeAtual(String clubeAtual) {
        this.clubeAtual = clubeAtual;
    }

    public int getReputacaoJogador() {
        return reputacaoJogador;
    }

    public double getPreco() {
        return preco;
    }

    public boolean jogadorPossuiInteresseNaTransferencia(Clube clube){
        return clube.getReputacaoClube() >= 1;
    }
    public double valorDeCompra(Apetite apetiteFinanceiro) {
        if (apetiteFinanceiro.getNome().equals("CONSERVADOR")) {
            return this.getPreco() + (getPreco() * PERCENTUAL_CONSERVADOR);
        } else if (apetiteFinanceiro.getNome().equals("MERCENÁRIO")) {
            return this.getPreco() + (getPreco() * PERCENTUAL_MERCENARIO);
        } else {
            return getPreco();
        }
    }
}
