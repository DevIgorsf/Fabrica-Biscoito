package UFLA.avancada.FabricaBiscoito.domain.fila;

import UFLA.avancada.FabricaBiscoito.domain.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.domain.linha.Linha;

import java.util.List;

public interface Fila extends Runnable {

    List<Biscoito> getBiscoitoLista();

    int getBiscoitoListaSize();

    boolean getPermiteRecheado();

    void adicionaBiscoito(Biscoito biscoito);

    Linha getLinha();

    void run();

    int getTamanho();

    void biscoitoPronto();

}
