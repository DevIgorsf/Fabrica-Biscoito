package UFLA.avancada.FabricaBiscoito.model.fila;

import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.model.linha.Linha;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilaBuilder {

    private List<Fila> listaFila = new ArrayList<>();

    public FilaBuilder () {
        listaFila.add(new FilaProducao1());
        listaFila.add(new FilaProducao2());
        listaFila.add(new FilaProducao3());
    }

    public List<Fila> getListaFila () {
        Collections.sort(this.listaFila, new ComparadorFilaProducao());

        return this.listaFila;
    }

    public Fila AdicionaBiscoito(Biscoito biscoito) {
        if(biscoito.getEhRecheado()) {
            if(this.getListaFila().get(0).getPermiteRecheado()){
                this.getListaFila().get(0).adicionaBiscoito(biscoito);
                return this.getListaFila().get(0);
            } else {
                this.getListaFila().get(1).adicionaBiscoito(biscoito);
                return this.getListaFila().get(1);
            }
        }else {
            this.getListaFila().get(0).adicionaBiscoito(biscoito);
            return this.getListaFila().get(0);
        }
    }

}
