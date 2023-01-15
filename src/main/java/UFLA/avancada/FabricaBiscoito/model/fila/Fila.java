package UFLA.avancada.FabricaBiscoito.model.fila;

import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.model.linha.Linha;
import lombok.Getter;

import java.util.List;
import java.util.Vector;

public interface Fila extends Runnable {

    Biscoito getBiscoitoLista();

    int getBiscoitoListaSize();

    boolean getPermiteRecheado();

    void adicionaBiscoito(Biscoito biscoito);

    Linha getLinha();

    public void run();

}
