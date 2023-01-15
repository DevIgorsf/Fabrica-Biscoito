package UFLA.avancada.FabricaBiscoito.model.fila;

import UFLA.avancada.FabricaBiscoito.model.forno.Forno1;
import UFLA.avancada.FabricaBiscoito.model.forno.Forno2;
import UFLA.avancada.FabricaBiscoito.model.linha.Linha;
import UFLA.avancada.FabricaBiscoito.model.linha.LinhaProducao2;
import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;
import lombok.Getter;

import java.util.List;
import java.util.Vector;

@Getter
public class FilaProducao2 implements Runnable, Fila {
    private List<Biscoito> biscoitoLista = new Vector<Biscoito>();
    private LinhaProducao2 linhaProducao;
    private Forno1 forno1;
    private Forno2 forno2;

    @Override
    public void run() {
        synchronized (this.linhaProducao) {
            System.out.println("Começando a gerenciar a tx");
            linhaProducao.montar();
            if(forno1.getOcupado()) {
                synchronized (this.forno1) {
                    System.out.println("procesando biscoito linha de produção 2");
                    forno1.assar(biscoitoLista.remove(0));
                }
            } else {
                synchronized (this.forno2) {
                    System.out.println("Assando biscoito forno 2");
                    forno2.assar(biscoitoLista.remove(0));
                }
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
