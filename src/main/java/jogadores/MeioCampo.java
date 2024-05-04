package jogadores;

public class MeioCampo extends Jogador {

    private static final double PERCENTUAL_MEIO_CAMPO = 0.3;
    public MeioCampo(String nome, int idade, String clubeAtual, int reputacaoJogador, Apetite apetiteFinanceiro, double preco) {
        super(nome, idade, clubeAtual, reputacaoJogador, apetiteFinanceiro, preco);
    }

    @Override
    public double valorDeCompra(Apetite apetiteFinanceiro) {
        if(this.getIdade() > 30){
            return (super.valorDeCompra(apetiteFinanceiro) - (super.valorDeCompra(apetiteFinanceiro) * PERCENTUAL_MEIO_CAMPO));
        } else {
            return super.valorDeCompra(apetiteFinanceiro);
        }
    }

    @Override
    public boolean jogadorPossuiInteresseNaTransferencia(Clube clube){
        if (clube.getReputacaoClube() > getReputacaoJogador() - 2) {return true;} return false;
    }
}
