package negociacoes;

import jogadores.Clube;
import jogadores.Jogador;

public class Negociacao {
    public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse){
        if ((jogadorDeInteresse.jogadorPossuiInteresseNaTransferencia(clubeInteressado))) {
            if (clubeInteressado.getSaldoDisponivelEmCaixa() >= jogadorDeInteresse.getPreco()) {
                jogadorDeInteresse.setClubeAtual(String.valueOf(clubeInteressado));
                clubeInteressado.setSaldoDisponivelEmCaixa(clubeInteressado.getSaldoDisponivelEmCaixa() - jogadorDeInteresse.getPreco());
                return true;
            } else return false;
        } else return false;
    }
}
