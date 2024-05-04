package jogadores;

public class Atacante extends Jogador{

    private int quantidadeGols;
    public static final double PERCENTUAL_ATACANTE = 0.1;
    public static final double PERCENTUAL_DESCONTO = 0.25;
    public Atacante(String nome, int idade, String clubeAtual, int reputacaoJogador, Apetite apetiteFinanceiro, double preco, int quantidadeGols) {
        super(nome, idade, clubeAtual, reputacaoJogador, apetiteFinanceiro, preco);
        this.quantidadeGols = quantidadeGols;
    }

    @Override
    public double valorDeCompra(Apetite apetiteFinanceiro) {
        if (this.getIdade() > 30) {
            return (super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_ATACANTE * quantidadeGols))) -  ((super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_ATACANTE * quantidadeGols)))* PERCENTUAL_DESCONTO);
        } else {
            return (super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_ATACANTE * quantidadeGols)));
        }
    }

    @Override
    public boolean jogadorPossuiInteresseNaTransferencia(Clube clube){
        if (clube.getReputacaoClube() > this.getReputacaoJogador()) {return true;} return false;
    }
}
