package jogadores;

public class Clube {
    private String nome;
    private int reputacaoClube;
    private double saldoDisponivelEmCaixa;

    public Clube(String nome, int reputacaoClube, double saldoDisponivelEmCaixa) {
        this.nome = nome;
        this.reputacaoClube = reputacaoClube;
        this.saldoDisponivelEmCaixa = saldoDisponivelEmCaixa;
    }

    public int getReputacaoClube() {return reputacaoClube;}
    public double getSaldoDisponivelEmCaixa() {return saldoDisponivelEmCaixa;}
    public void setSaldoDisponivelEmCaixa(double saldoDisponivelEmCaixa) {
        this.saldoDisponivelEmCaixa = saldoDisponivelEmCaixa;
    }
}
