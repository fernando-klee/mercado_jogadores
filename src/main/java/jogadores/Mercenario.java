package jogadores;

public class Mercenario extends Apetite {
    private static final String NOME = "MERCENÁRIO";
    public static final double PERCENTUAL_MERCENARIO =  0.8;

    public Mercenario() {
    }
    @Override
    public String getNome() {
        return NOME;
    }
}
