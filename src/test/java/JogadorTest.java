import jogadores.*;
import negociacoes.Negociacao;
import org.junit.Assert;
import org.junit.Test;

public class JogadorTest {
    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Juventus", 10, 1000000);
        Goleiro goleiro = new Goleiro("Buffon", 33, null, 8, new Indiferente(), 800500, 12);

        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Caxias", 3, 100000000);
        Atacante atacante = new Atacante("Cristiano Ronaldo", 38, null, 10, new Conservador(), 800500, 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertFalse(foiPossivelNegociar);
        }

    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Santos", 10, 1000);
        MeioCampo meioCampo = new MeioCampo("Djalminha", 29,"La Corunã", 10, new Indiferente(), 870000);

        boolean foiPossivelNegociar = negociacao.negociar(clube, meioCampo);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Real Madrid", 10, 10000000);
        MeioCampo meioCampo = new MeioCampo("Allan Patrick", 25, "São Paulo", 9,new Conservador(), 20000);
        double valorEsperado = 28000;

        double precoCalculado = meioCampo.valorDeCompra(new Conservador());

        Assert.assertEquals(valorEsperado, precoCalculado, 0.01);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Real Madrid", 10, 10000000);
        MeioCampo meioCampo = new MeioCampo("De Paul", 33, "Ajax", 10,new Mercenario(), 40000);
        double valorEsperado = 50400;

        double precoCalculado = meioCampo.valorDeCompra(new Mercenario());

        Assert.assertEquals(valorEsperado, precoCalculado, 0.01);
    }

    @Test
    public void deveCalculcarCorretamenteOPrecoDoZagueiroComMenosDeTrintaAnos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Porto", 10, 20000000);
        Zagueiro zagueiro = new Zagueiro("João Augusto", 19, "Vasco", 10, new Conservador(), 10000);
        double precoEsperado = 14000;
        // Act
        double precoCalculado = zagueiro.valorDeCompra(new Conservador());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoLateralComMenosDeVinteOitoAnos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Barcelona", 10, 20000000);
        Lateral lateral = new Lateral("Rafinha", 18, "Botafogo", 1, new Indiferente(), 10000, 50);
        double precoEsperado = 12000;
        // Act
        double precoCalculado = lateral.valorDeCompra(new Indiferente());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }
    @Test
    public void deveCalcularCorretamenteOPrecoDoLateralComMaisDeVinteOitoAnos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Barcelona", 10, 20000000);
        Lateral lateral = new Lateral("Rafinha", 35, "Botafogo", 1, new Indiferente(), 10000, 50);
        double precoEsperado = 77000;
        // Act
        double precoCalculado = lateral.valorDeCompra(new Indiferente());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoZagueiroComMaisDeTrintaAnos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Milan", 10, 2000000);
        Zagueiro zagueiro = new Zagueiro("Mercado", 33, "Fluminense", 10, new Indiferente(), 10000);
        double precoEsperado = 8000;
        // Act
        double precoCalculado = zagueiro.valorDeCompra(new Indiferente());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }

    @Test
    public void deveRetornarPrecoDoAtacanteComMenosDeTrintaAnos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Real Madrid", 10, 20000);
        Atacante atacante = new Atacante("Endrick", 18, "Palmeiras", 1, new Indiferente(), 100000, 30);
        double precoEsperado = 400000;
        // Act
        double precoCalculado = atacante.valorDeCompra(new Indiferente());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }

    @Test
    public void deveRetornarSemClubeQuandoOClubeForNull(){

        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Milan", 10, 2000000);
        Atacante atacante = new Atacante("Antony", 18, null, 1, new Indiferente(), 10000, 15);
        String clubeEsperado = "Sem Clube";

        String clubeEncontrado = atacante.getClubeAtual();

        Assert.assertEquals(clubeEsperado, clubeEncontrado);
    }

    @Test
    public void deveRetornarClubeDoJogador(){
        Goleiro rochet = new Goleiro("Rochet", 25, null, 10, new Conservador(), 20000, 10);
        String clubeEsperado = "Sem Clube";

        String clubeCalculado = rochet.getClubeAtual();

        Assert.assertEquals(clubeEsperado, clubeCalculado);
    }

    @Test
    public void deveCalculcarCorretamenteOPrecoDoGoleiro(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 20000);
        Goleiro goleiro = new Goleiro("Buffon", 31, "Juventus", 1, new Conservador(), 10000, 8);
        double precoEsperado = 58800;
        // Act
        double precoCalculado = goleiro.valorDeCompra(new Conservador());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }
    @Test
    public void deveRetornarQueOMeioCampoNaoTemInteresseEmClubeComReputacaoUmAMenosQueEleOuMais(){
        // arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 9, 100000000);
        MeioCampo meia = new MeioCampo("Cristiano Ronaldo", 35, "United", 10, new Conservador(), 800500);
        // act
        boolean foiPossivelNegociar = negociacao.negociar(clube, meia);
        // assert
        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void deveRetornarPrecoDoAtacanteComMaisDeTrintaAnos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Real Madrid", 10, 20000);
        Atacante atacante = new Atacante("Benzema", 35, "Porto", 1, new Indiferente(), 100000, 30);
        double precoEsperado = 300000;
        // Act
        double precoCalculado = atacante.valorDeCompra(new Indiferente());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }

    @Test
    public void deveRetornarQueOMeioCampoNaoTemInteresseEmClubeComDuasReputacaoAMenosQueEle(){
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 8, 100000000);
        MeioCampo meioCampo = new MeioCampo("Rivaldo", 35, "Plameiras", 10, new Conservador(), 800500);

        boolean foiPossivelNegociar = negociacao.negociar(clube, meioCampo);

        Assert.assertFalse(foiPossivelNegociar);
    }
}
