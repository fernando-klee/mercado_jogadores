package jogadores;

public class Goleiro extends  Jogador {

    private int penaltisDefendidosNoAno;
    private static final double PERCENTUAL_PENALTI_DEFENDIDO = 0.4;
    public Goleiro(String nome, int idade, String clubeAtual, int reputacaoHistorica, Apetite apetiteFinanceiro, double preco, int penaltisDefendidosNoAno) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.penaltisDefendidosNoAno = penaltisDefendidosNoAno;
    }
    @Override
    public double valorDeCompra(Apetite apetiteFinanceiro) {return (super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_PENALTI_DEFENDIDO * penaltisDefendidosNoAno)));}
}
