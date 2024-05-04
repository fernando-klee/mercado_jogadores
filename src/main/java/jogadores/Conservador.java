package jogadores;

public class Conservador extends Apetite {
    private static final String NOME = "CONSERVADOR";
    public static final double PERCENTUAL_CONSERVADOR =  0.4;

    public Conservador() {
    }
    @Override
    public String getNome() {
        return NOME;
    }
}
