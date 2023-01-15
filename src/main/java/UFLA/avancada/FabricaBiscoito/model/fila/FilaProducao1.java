package UFLA.avancada.FabricaBiscoito.model.fila;

import UFLA.avancada.FabricaBiscoito.model.forno.Forno1;
import UFLA.avancada.FabricaBiscoito.model.linha.Linha;
import UFLA.avancada.FabricaBiscoito.model.linha.LinhaProducao1;
import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;
import lombok.Getter;

import java.util.List;
import java.util.Vector;

@Getter
public class FilaProducao1 implements Runnable, Fila {
    private List<Biscoito> biscoitoLista = new Vector<Biscoito>();
    private LinhaProducao1 linhaProducao;
    private Forno1 forno;

    @Override
    public void run() {
        synchronized (this.linhaProducao) {
            System.out.println("procesando biscoito linha de produção 1");
            linhaProducao.montar();
            synchronized (this.forno) {
                System.out.println("Assando biscoito forno 1");
                forno.assar(biscoitoLista.remove(0));

            }
        }
    }

    @Override
    public int getBiscoitoListaSize() {
        return this.biscoitoLista.size();
    }

    @Override
    public boolean getPermiteRecheado() {
        return true;
    }

    @Override
    public void adicionaBiscoito(Biscoito biscoito) {
        this.biscoitoLista.add(biscoito);
    }

    @Override
    public Linha getLinha() {
        return this.linhaProducao;
    }
}
