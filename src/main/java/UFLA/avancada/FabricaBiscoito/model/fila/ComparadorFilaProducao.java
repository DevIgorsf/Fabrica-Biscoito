package UFLA.avancada.FabricaBiscoito.model.fila;

import java.util.Comparator;

public class ComparadorFilaProducao implements Comparator<Fila> {

    public int compare(Fila fila01, Fila fila02) {
        if (fila01.getBiscoitoListaSize() < fila02.getBiscoitoListaSize()) return -1;
        else if (fila01.getBiscoitoListaSize() > fila02.getBiscoitoListaSize()) return +1;
        else return 0;
    }
}
