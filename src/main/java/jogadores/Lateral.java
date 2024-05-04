package jogadores;

public class Lateral extends  Jogador {
    private int cruzamentosCerteiros;
    public static final double PERCENTUAL_LATERAL = 0.2;
    public static final double PERCENTUAL_IDADE = 0.3;
    public Lateral(String nome, int idade, String clubeAtual, int reputacaoJogador, Apetite apetiteFinanceiro, double preco, int cruzamentosCerteiros) {
        super(nome, idade, clubeAtual, reputacaoJogador, apetiteFinanceiro, preco);
        this.cruzamentosCerteiros = cruzamentosCerteiros;
    }

    @Override
    public double valorDeCompra(Apetite apetiteFinanceiro) {
        if (this.getIdade() > 28) {
            return (super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_LATERAL * cruzamentosCerteiros))) - ((super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_LATERAL * cruzamentosCerteiros))) * PERCENTUAL_IDADE);
        } else {
            return (super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * PERCENTUAL_LATERAL));
        }
    }
}
