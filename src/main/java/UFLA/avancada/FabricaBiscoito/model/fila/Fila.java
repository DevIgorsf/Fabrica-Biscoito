package UFLA.avancada.FabricaBiscoito.model.fila;

import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.model.linha.Linha;

import java.util.List;

public interface Fila extends Runnable {

    List<Biscoito> getBiscoitoLista();

    int getBiscoitoListaSize();

    boolean getPermiteRecheado();

    void adicionaBiscoito(Biscoito biscoito);

    Linha getLinha();

    public void run();

    public int getTamanho();

}
